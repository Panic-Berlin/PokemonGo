package com.example.pokemongo.features.searchpokemon.di

import android.content.Context
import com.example.pokemongo.features.searchpokemon.presentation.SearchPokemonFragment
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit

@Component(
    modules = [
        PokemonSearchFeatureModule::class,
        PokemonViewModelModule::class
    ]
)
interface PokemonSearchComponent {
    fun inject(searchPokemonFragment: SearchPokemonFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun retrofit(retrofit: Retrofit): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): PokemonSearchComponent
    }
}
