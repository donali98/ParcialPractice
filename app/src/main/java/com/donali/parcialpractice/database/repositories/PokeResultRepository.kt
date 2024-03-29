package com.donali.parcialpractice.database.repositories

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.donali.parcialpractice.database.daos.PokeResultDao
import com.donali.parcialpractice.database.models.PokeResult
import com.donali.parcialpractice.services.retrofit.PokeResultService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PokeResultRepository(private val pokeResultDao: PokeResultDao) {

    @WorkerThread
    suspend fun insert(pokeResult: PokeResult) = pokeResultDao.insert(pokeResult)

    @WorkerThread
    suspend fun deleteAllPokeResults() = pokeResultDao.deleteAllPokeResults()


    fun getAllPokeResults():LiveData<List<PokeResult>> = pokeResultDao.getAllPokeResults()
    fun getAllPokeResultsNoLiveData():List<PokeResult> = pokeResultDao.getAllPokeResultsNoLiveData()

    @WorkerThread
    suspend  fun updateFavorite(isFv:Boolean,pId:Long) = pokeResultDao.updateFavorite(isFv,pId)


    fun retreivePokeResults() = GlobalScope.launch(Dispatchers.IO){
        if(this@PokeResultRepository.getAllPokeResultsNoLiveData().isEmpty()){
            this@PokeResultRepository.deleteAllPokeResults()
            val response = PokeResultService.getPokeResultService().queryPokeResults(20,0).await()
            if(response.isSuccessful){
                with(response){
                    this.body()?.results?.forEach {
                        //                    Log.d("CUSTOM",it.name)
                        this@PokeResultRepository.insert(it)
                    }

                }
            }
            else with(response){
                Log.e("CUSTOM",this.code().toString())
            }
        }

    }

}