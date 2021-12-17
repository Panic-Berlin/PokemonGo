package com.example.pokemongo.features.searchpokemon.data.entity

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPokemon(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemon_table ORDER BY id ASC")
    fun readData(): LiveData<List<PokemonEntity>>
}
