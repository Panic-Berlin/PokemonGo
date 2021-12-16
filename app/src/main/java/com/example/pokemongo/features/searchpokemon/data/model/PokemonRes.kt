package com.example.pokemongo.features.searchpokemon.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonRes(
    @Json(name = "base_experience")
    val baseExperience: Int,
    val height: Int,
    val id: Long,
    @Json(name = "is_default")
    val isDefault: Boolean,
    val name: String,
    val order: Int,
    val weight: Int
)
