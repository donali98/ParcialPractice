package com.donali.parcialpractice.services.retrofit

import com.donali.parcialpractice.database.models.PokeResult
import com.donali.parcialpractice.database.models.PokeTypeRetrofit
import com.donali.parcialpractice.database.models.PokemonInfoResponse
import com.donali.parcialpractice.database.models.PokemonRetrofit
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


const val BASE_URL = "https://pokeapi.co/api/v2/"

interface PokeResultService {
    @GET("pokemon")
    fun queryPokeResults(@Query("limit")limit:Int,@Query("offset")offset:Int):Deferred<Response<PokemonInfoResponse>>
    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id")id:Int):Deferred<Response<PokemonRetrofit>>
    companion object{
        fun getPokeResultService():PokeResultService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(PokeResultService::class.java)
    }
}