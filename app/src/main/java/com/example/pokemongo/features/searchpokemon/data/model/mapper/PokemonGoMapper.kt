package com.example.pokemongo.features.searchpokemon.data.model.mapper

import com.example.pokemongo.features.searchpokemon.data.model.PokemonRes
import com.example.pokemongo.features.searchpokemon.domain.model.Pokemon
import javax.inject.Inject

class PokemonGoMapper @Inject constructor() {

    fun map(pokemonRes: PokemonRes) = Pokemon(
        baseExperience = pokemonRes.baseExperience,
        height = pokemonRes.height,
        name = pokemonRes.name,
        weight = pokemonRes.weight
    )
}
