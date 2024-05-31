package com.example.pokemonappvk.data.datasource.pokemons

import com.example.pokemonappvk.data.api.PokemonsListApi
import com.example.pokemonappvk.data.response.PokemonsResponse
import javax.inject.Inject

const val PAGING_LIMIT = 20

class PokemonsListDataSourceImpl @Inject constructor(
    private val api: PokemonsListApi
) : PokemonsListDataSource {
    override suspend fun getPokemonsList(page: Int): PokemonsResponse {
        return api.getPokemonsList(
            limit = PAGING_LIMIT,
            offset = page * PAGING_LIMIT
        )
    }
}