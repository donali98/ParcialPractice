package com.donali.parcialpractice.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.donali.parcialpractice.database.RoomDB
import com.donali.parcialpractice.database.models.Pokemon
import com.donali.parcialpractice.database.repositories.PokeResultRepository
import com.donali.parcialpractice.database.repositories.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokeResultViewModel(private val app:Application):AndroidViewModel(app) {
    private val repository:PokeResultRepository
    private val pokemonRepository:PokemonRepository
    init {
        val repoDao = RoomDB.getInstance(app).pokeResultDao()
        val pokemonDao = RoomDB.getInstance(app).pokemonDao()

        repository = PokeResultRepository(repoDao)
        pokemonRepository = PokemonRepository(pokemonDao)

    }

    fun insertPokemon(pokemon:Pokemon) = viewModelScope.launch (Dispatchers.IO){
        pokemonRepository.insert(pokemon)
    }

    fun retreivePokemonInfo(id:Long) = pokemonRepository.retreivePokemonInfo(id)

    fun retreivePokeResults() = repository.retreivePokeResults()

    fun getAllPokeResults () = repository.getAllPokeResults()


    fun updateFavorite(isFv:Boolean,pId:Long) = viewModelScope.launch (Dispatchers.IO){
        repository.updateFavorite(isFv,pId)
    }
}