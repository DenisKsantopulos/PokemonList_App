package com.example.pokemonapp.domain.repository.details

import com.example.pokemonapp.domain.model.PokemonDetails
import com.example.pokemonapp.domain.model.resource.ResultState

interface PokemonDetailsRepository {
    suspend fun getPokemonDetails(name: String): ResultState<PokemonDetails>
}