package com.example.pokemonappvk.data.datasource.details

import com.example.pokemonappvk.domain.model.PokemonDetails
import com.example.pokemonappvk.domain.model.resource.ResultState

interface PokemonDetailsDataSource {
    suspend fun getPokemonsDetails(name: String): ResultState<PokemonDetails>
}