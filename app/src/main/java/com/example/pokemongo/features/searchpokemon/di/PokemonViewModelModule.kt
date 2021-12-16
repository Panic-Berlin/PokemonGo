package com.example.pokemongo.features.searchpokemon.di

import androidx.lifecycle.ViewModel
import com.example.pokemongo.di.ViewModelKey
import com.example.pokemongo.features.searchpokemon.presentation.SearchPokemonViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PokemonViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SearchPokemonViewModel::class)
    fun bindsSearchPokemonViewModel(impl: SearchPokemonViewModel): ViewModel
}
