package com.example.pokemongo.features.randompokemon.di

import com.example.pokemongo.features.searchpokemon.data.api.PokemonApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RandomPokemonFeatureModule {
    @Provides
    fun providePokemonApi(retrofit: Retrofit) = retrofit.create(PokemonApi::class.java)
}
