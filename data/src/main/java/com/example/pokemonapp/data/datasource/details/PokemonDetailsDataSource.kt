package com.example.pokemonapp.data.datasource.details

import com.example.pokemonapp.domain.model.PokemonDetails
import com.example.pokemonapp.domain.model.resource.ResultState


interface PokemonDetailsDataSource {
    suspend fun getPokemonsDetails(name: String): ResultState<PokemonDetails>
}