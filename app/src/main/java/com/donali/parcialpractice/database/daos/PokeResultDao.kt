package com.donali.parcialpractice.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.donali.parcialpractice.database.models.PokeResult

@Dao
interface PokeResultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokeResult:PokeResult)

    @Query("select * from poke_result")
    fun getAllPokeResults():LiveData<List<PokeResult>>

    @Query("select * from poke_result")
    fun getAllPokeResultsNoLiveData():List<PokeResult>

    @Query("update  poke_result set is_favorite =:isFv where id = :pId")
    suspend fun updateFavorite(isFv:Boolean,pId:Long)

    @Query("delete from poke_result")
    suspend fun deleteAllPokeResults()
}