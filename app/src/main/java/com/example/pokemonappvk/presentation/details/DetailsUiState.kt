package com.example.pokemonappvk.presentation.details

import com.example.pokemonappvk.domain.model.PokemonDetails

sealed class DetailsUiState {
    data object Loading : DetailsUiState()
    data object Idle : DetailsUiState()
    data class Success(val data: PokemonDetails) : DetailsUiState()
    data class Exception(val code: Int, val exception: Throwable) : DetailsUiState()
}