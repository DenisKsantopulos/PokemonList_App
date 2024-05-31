package com.example.pokemonapp.domain.usecase.detail

import kotlinx.coroutines.flow.Flow

interface GetPokemonDetailsUseCase {
    suspend fun invoke(name: String): Flow<PokemonDetailsRequestState>
}