package com.example.pokemongo.features.randompokemon.di

import androidx.lifecycle.ViewModel
import com.example.pokemongo.di.ViewModelKey
import com.example.pokemongo.features.randompokemon.presentation.RandomPokemonViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface RandomPokemonViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RandomPokemonViewModel::class)
    fun bindRandomPokemonViewModel(impl: RandomPokemonViewModel): ViewModel
}
