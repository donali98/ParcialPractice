package com.donali.parcialpractice.database.models

import com.squareup.moshi.Json

class PokeTypeRetrofit(
    @field:Json(name = "slot" )
    val slot:Int,
    @field:Json(name = "type")
    val type:TypeTemplate
) {
}