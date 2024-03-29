package com.donali.parcialpractice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.donali.parcialpractice.database.daos.PokeResultDao
import com.donali.parcialpractice.database.daos.PokemonDao
import com.donali.parcialpractice.database.models.PokeResult
import com.donali.parcialpractice.database.models.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [PokeResult::class,Pokemon::class], version = 4, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun pokeResultDao(): PokeResultDao
    abstract fun pokemonDao(): PokemonDao


    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(context: Context): RoomDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context, RoomDB::class.java, "Pokemon_Database")
                        .fallbackToDestructiveMigration()
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}