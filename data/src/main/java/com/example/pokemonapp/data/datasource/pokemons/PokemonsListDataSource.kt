package com.example.pokemonapp.data.datasource.pokemons

import com.example.pokemonapp.data.response.PokemonsResponse


interface PokemonsListDataSource {
    suspend fun getPokemonsList(page: Int): PokemonsResponse
}