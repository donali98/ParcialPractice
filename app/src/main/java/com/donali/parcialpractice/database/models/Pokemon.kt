package com.donali.parcialpractice.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="pokemon")
data class Pokemon(
    @ColumnInfo(name="name")
    val name:String,
    @ColumnInfo(name="sprite")
    val sprite:String
) {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}