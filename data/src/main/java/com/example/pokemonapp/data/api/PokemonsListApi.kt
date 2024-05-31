package com.example.pokemonapp.data.api

import com.example.pokemonapp.data.response.PokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonsListApi {

    @GET("pokemon")
    suspend fun getPokemonsList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): PokemonsResponse
}