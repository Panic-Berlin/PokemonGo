package com.example.pokemongo.features.searchpokemon.data.entity

import androidx.lifecycle.LiveData

class PokemonRepository(private val pokemonDao: PokemonDao) {

    val readAllData: LiveData<List<PokemonEntity>> = pokemonDao.readData()

    suspend fun addPokemon(pokemon: PokemonEntity){
        pokemonDao.addPokemon(pokemon)
    }
}
