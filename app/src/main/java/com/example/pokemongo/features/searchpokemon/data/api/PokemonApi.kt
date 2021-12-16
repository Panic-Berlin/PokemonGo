package com.example.pokemongo.features.searchpokemon.data.api

import com.example.pokemongo.features.searchpokemon.data.model.PokemonRes
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): PokemonRes
}
