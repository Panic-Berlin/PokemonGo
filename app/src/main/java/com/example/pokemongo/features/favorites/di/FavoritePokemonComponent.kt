package com.example.pokemongo.features.favorites.di

import android.content.Context
import com.example.pokemongo.features.favorites.presentation.FavoritePokemonFragment
import com.example.pokemongo.features.searchpokemon.di.PokemonSearchFeatureModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        PokemonSearchFeatureModule::class,
        FavoritePokemonViewModelModule::class
    ]
)
interface FavoritePokemonComponent {

    fun inject(favoritePokemonFragment: FavoritePokemonFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): FavoritePokemonComponent
    }
}
