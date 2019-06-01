package com.donali.parcialpractice.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.donali.parcialpractice.database.RoomDB
import com.donali.parcialpractice.database.repositories.PokeResultRepository

class PokeResultViewModel(private val app:Application):AndroidViewModel(app) {
    private val repository:PokeResultRepository
    init {
        val repoDao = RoomDB.getInstance(app).pokeResultDao()
        repository = PokeResultRepository(repoDao)
    }

    fun retreivePokeResults() = repository.retreivePokeResults()
}