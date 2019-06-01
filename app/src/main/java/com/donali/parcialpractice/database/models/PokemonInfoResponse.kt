package com.donali.parcialpractice.database.models

import com.squareup.moshi.Json

class PokemonInfoResponse(
    @field:Json(name ="results")
    val results:List<PokeResult>
)