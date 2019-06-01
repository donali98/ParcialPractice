package com.donali.parcialpractice.database.models

import androidx.room.ColumnInfo
import com.squareup.moshi.Json

class PokemonRetrofit (
    @field:Json(name = "name")
    val name:String,
    @field:Json(name="types")
    val types:List<PokeTypeRetrofit>
){
}