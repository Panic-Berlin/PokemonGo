package com.example.pokemongo.features.searchpokemon.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemongo.features.searchpokemon.domain.PokemonGoInteractor
import com.example.pokemongo.features.searchpokemon.domain.model.Pokemon
import com.example.pokemongo.utils.RequestResult
import com.example.pokemongo.utils.SingleLiveEvent
import com.example.pokemongo.utils.asLiveData
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchPokemonViewModel @Inject constructor(
    private val pokemonGoInteractor: PokemonGoInteractor
) : ViewModel() {

    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon get() = _pokemon.asLiveData()

    private val _isLoading = MutableLiveData(false)
    val isLoading get() = _isLoading.asLiveData()

    val showErrorEvent = SingleLiveEvent<Unit>()

    fun getPokemon(name: String) {
        _isLoading.value = true
        viewModelScope.launch {
            when (val pokemon = pokemonGoInteractor.getPokemon(name)) {
                is RequestResult.Failed.Error -> showErrorEvent.call()
                is RequestResult.Success -> _pokemon.value = pokemon.data
            }
            _isLoading.value = false
        }
    }
}
