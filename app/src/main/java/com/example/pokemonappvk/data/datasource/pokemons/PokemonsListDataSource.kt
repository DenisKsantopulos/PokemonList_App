package com.example.pokemonappvk.data.datasource.pokemons

import com.example.pokemonappvk.data.response.PokemonsResponse

interface PokemonsListDataSource {
    suspend fun getPokemonsList(page: Int): PokemonsResponse
}