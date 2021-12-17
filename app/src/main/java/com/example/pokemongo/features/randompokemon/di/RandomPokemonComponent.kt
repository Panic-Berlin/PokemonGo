package com.example.pokemongo.features.randompokemon.di

import com.example.pokemongo.features.randompokemon.presentation.RandomPokemonFragment
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit

@Component
    (
    modules = [
        RandomPokemonFeatureModule::class,
        RandomPokemonViewModelModule::class
    ]
)
interface RandomPokemonComponent {
    fun inject(randomPokemonFragment: RandomPokemonFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun retrofit(retrofit: Retrofit): Builder

        fun build(): RandomPokemonComponent
    }
}
