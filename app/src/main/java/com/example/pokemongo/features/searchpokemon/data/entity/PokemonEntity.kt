package com.example.pokemongo.features.searchpokemon.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val baseExperience: Int,
    val height: Int,
    val name: String,
    val weight: Int
)
