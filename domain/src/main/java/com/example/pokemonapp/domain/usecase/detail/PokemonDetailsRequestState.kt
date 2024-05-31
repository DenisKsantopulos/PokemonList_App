package com.example.pokemonapp.domain.usecase.detail

import com.example.pokemonapp.domain.model.PokemonDetails

sealed class PokemonDetailsRequestState {
    data object Loading : PokemonDetailsRequestState()
    data class Success(val data: PokemonDetails) : PokemonDetailsRequestState()
    data class Exception(val code: Int = -1, val exception: Throwable) :
        PokemonDetailsRequestState()
}