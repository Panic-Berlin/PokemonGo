package com.example.pokemongo.features.searchpokemon.data

import com.example.pokemongo.features.searchpokemon.data.api.PokemonApi
import com.example.pokemongo.features.searchpokemon.data.model.mapper.PokemonGoMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepo @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val pokemonGoMapper: PokemonGoMapper
) {

    suspend fun getPokemon(name: String) = withContext(Dispatchers.IO) {
        pokemonApi.getPokemon(name).let {
            pokemonGoMapper.map(it)
        }
    }
}
