package com.example.pokemongo.features.searchpokemon.domain

import com.example.pokemongo.features.searchpokemon.data.PokemonRepo
import com.example.pokemongo.utils.safeRequest
import javax.inject.Inject

class PokemonGoInteractor @Inject constructor(
    private val pokemonRepo: PokemonRepo
) {
    suspend fun getPokemon(name: String) = safeRequest {
        pokemonRepo.getPokemon(name)
    }
}
