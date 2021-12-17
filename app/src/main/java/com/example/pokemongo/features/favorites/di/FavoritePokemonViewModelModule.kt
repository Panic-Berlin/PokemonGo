package com.example.pokemongo.features.favorites.di

import androidx.lifecycle.ViewModel
import com.example.pokemongo.di.ViewModelKey
import com.example.pokemongo.features.favorites.presentation.FavoritePokemonViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FavoritePokemonViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FavoritePokemonViewModel::class)
    fun bindFavoritePokemonViewModel(imple: FavoritePokemonViewModel): ViewModel
}
