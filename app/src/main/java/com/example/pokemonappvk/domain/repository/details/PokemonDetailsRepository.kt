package com.example.pokemonappvk.domain.repository.details

import com.example.pokemonappvk.domain.model.PokemonDetails
import com.example.pokemonappvk.domain.model.resource.ResultState

interface PokemonDetailsRepository {
    suspend fun getPokemonDetails(name: String): ResultState<PokemonDetails>
}