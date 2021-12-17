package com.example.pokemongo.features.searchpokemon.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemongo.features.searchpokemon.data.entity.Pokemon
import com.example.pokemongo.features.searchpokemon.data.entity.PokemonDataBase
import com.example.pokemongo.features.searchpokemon.data.entity.PokemonRepository
import com.example.pokemongo.features.searchpokemon.domain.PokemonGoInteractor
import com.example.pokemongo.utils.RequestResult
import com.example.pokemongo.utils.SingleLiveEvent
import com.example.pokemongo.utils.asLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchPokemonViewModel @Inject constructor(
    applicationContext: Context,
    private val pokemonGoInteractor: PokemonGoInteractor
) : ViewModel() {

    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon get() = _pokemon.asLiveData()

    private val _isLoading = MutableLiveData(false)
    val isLoading get() = _isLoading.asLiveData()

    private val _favoriteVisible = MutableLiveData(false)
    val favoriteVisible get() = _favoriteVisible.asLiveData()

    val showErrorEvent = SingleLiveEvent<Unit>()

    private val readAllData: LiveData<List<Pokemon>>
    private val repository: PokemonRepository


    init {
        val pokemonDao = PokemonDataBase.getDataBase(context = applicationContext).pokemonDao()
        repository = PokemonRepository(pokemonDao)
        readAllData = repository.readAllData
    }

    fun getPokemon(name: String) {
        _isLoading.value = true
        viewModelScope.launch {
            when (val pokemon = pokemonGoInteractor.getPokemon(name)) {
                is RequestResult.Failed.Error -> showErrorEvent.call()
                is RequestResult.Success -> {
                    _pokemon.value = pokemon.data
                    _favoriteVisible.value = true
                }
            }
            _isLoading.value = false
        }
    }

    fun onAddFavoritePokemonClick() {
        viewModelScope.launch(Dispatchers.IO) {
            _pokemon.value?.let { repository.addPokemon(it) }
        }
    }
}
