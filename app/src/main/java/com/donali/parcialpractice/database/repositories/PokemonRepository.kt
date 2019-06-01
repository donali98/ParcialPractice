package com.donali.parcialpractice.database.repositories

import android.util.Log
import androidx.annotation.WorkerThread
import com.donali.parcialpractice.database.daos.PokemonDao
import com.donali.parcialpractice.database.models.Pokemon
import com.donali.parcialpractice.services.retrofit.PokeResultService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PokemonRepository (private val pokemonDao: PokemonDao) {

    @WorkerThread
    suspend fun insert(pokemon: Pokemon) = pokemonDao.insert(pokemon)


    fun retreivePokemonInfo(id: Long) = GlobalScope.launch(Dispatchers.IO) {
        val resp = PokeResultService.getPokeResultService().getPokemonInfo(id).await()
        if (resp.isSuccessful) {
            with(resp) {
//                Log.d("CUSTOM", this.body()!!.name)
                val pokemon = Pokemon(this.body()!!.name,this.body()!!.sprites.front_default)
                pokemonDao.insert(pokemon)

            }
        } else with(resp) {
            Log.e("CUSTOM", this.code().toString())
        }

    }
}