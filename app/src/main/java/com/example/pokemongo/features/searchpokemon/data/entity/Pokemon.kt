package com.example.pokemongo.features.searchpokemon.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val baseExperience: Int,
    val height: Int,
    val name: String,
    val weight: Int
)
