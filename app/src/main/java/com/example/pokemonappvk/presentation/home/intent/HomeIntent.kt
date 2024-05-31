package com.example.pokemonappvk.presentation.home.intent

sealed class HomeIntent {
    data object GetPokemonsList : HomeIntent()
}