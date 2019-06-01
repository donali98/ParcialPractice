package com.donali.parcialpractice.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "poke_result")
data class PokeResult(

//    @field:Json(name = "name")
    @ColumnInfo(name = "name")
    var name: String,

//    @field:Json(name = "url")
    @ColumnInfo(name = "url")
    var url: String
) {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
    @ColumnInfo(name="is_favorite")
    var isFavorite:Boolean = false
}