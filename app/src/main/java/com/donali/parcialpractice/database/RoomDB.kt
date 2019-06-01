package com.donali.parcialpractice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.donali.parcialpractice.database.daos.PokeResultDao
import com.donali.parcialpractice.database.models.PokeResult

@Database(entities = [PokeResult::class],version = 1,exportSchema = false)
abstract class RoomDB:RoomDatabase() {

    abstract fun pokeResultDao():PokeResultDao

    companion object{
        @Volatile
        private var INSTANCE:RoomDB? = null

        fun getInstance(context: Context):RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context,RoomDB::class.java,"Pokemon_Database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}