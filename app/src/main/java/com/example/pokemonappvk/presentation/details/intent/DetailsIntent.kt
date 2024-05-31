package com.example.pokemonappvk.presentation.details.intent

sealed class DetailsIntent {
    data class GetDetails(val name: String) : DetailsIntent()
}