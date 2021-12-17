package com.example.pokemongo.features.searchpokemon.data.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pokemon::class], version = 1, exportSchema = false)
abstract class PokemonDataBase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    companion object{
        @Volatile
        private var INSTANCE: PokemonDataBase? = null

        fun getDataBase(context: Context): PokemonDataBase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PokemonDataBase::class.java,
                    "pokemon_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
