package com.example.pokemonappvk.data.api

import com.example.pokemonappvk.data.entity.PokemonDetailsEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonDetailsApi {

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): Response<PokemonDetailsEntity>
}