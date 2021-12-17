package com.example.pokemongo.features.searchpokemon.data.entity

import androidx.lifecycle.LiveData

class PokemonRepository(private val pokemonDao: PokemonDao) {

    val readAllData: LiveData<List<Pokemon>> = pokemonDao.readData()

    suspend fun addPokemon(pokemon: Pokemon){
        pokemonDao.addPokemon(pokemon)
    }
}
