package com.example.pokemongo.features.searchpokemon.di

import com.example.pokemongo.features.searchpokemon.data.api.PokemonApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class PokemonSearchFeatureModule {
    @Provides
    fun providePokemonApi(retrofit: Retrofit) = retrofit.create(PokemonApi::class.java)
}
