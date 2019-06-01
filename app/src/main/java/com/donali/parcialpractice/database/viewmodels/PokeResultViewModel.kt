package com.donali.parcialpractice.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.donali.parcialpractice.database.RoomDB
import com.donali.parcialpractice.database.repositories.PokeResultRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokeResultViewModel(private val app:Application):AndroidViewModel(app) {
    private val repository:PokeResultRepository
    init {
        val repoDao = RoomDB.getInstance(app).pokeResultDao()
        repository = PokeResultRepository(repoDao)
    }

    fun retreivePokeResults() = repository.retreivePokeResults()

    fun getAllPokeResults () = repository.getAllPokeResults()
    fun getAllPokeResultsNoLiveData () = repository.getAllPokeResultsNoLiveData()

    fun updateFavorite(isFv:Boolean,pId:Long) = viewModelScope.launch (Dispatchers.IO){
        repository.updateFavorite(isFv,pId)
    }
}