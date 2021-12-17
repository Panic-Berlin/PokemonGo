package com.example.pokemongo.features.favorites.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pokemongo.features.searchpokemon.data.entity.PokemonDataBase
import com.example.pokemongo.features.searchpokemon.data.entity.Pokemon
import com.example.pokemongo.features.searchpokemon.data.entity.PokemonRepository
import javax.inject.Inject

class FavoritePokemonViewModel @Inject constructor(
    applicationContext: Context
) : ViewModel() {

    val readAllData: LiveData<List<Pokemon>>
    private val repository: PokemonRepository

    init {
        val pokemonDao = PokemonDataBase.getDataBase(applicationContext).pokemonDao()
        repository = PokemonRepository(pokemonDao)
        readAllData = repository.readAllData
    }

}
