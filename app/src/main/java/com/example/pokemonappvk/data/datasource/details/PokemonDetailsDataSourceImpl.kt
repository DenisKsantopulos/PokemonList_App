package com.example.pokemonappvk.data.datasource.details

import com.example.pokemonappvk.data.api.PokemonDetailsApi
import com.example.pokemonappvk.data.mapper.PokemonDetailsMapper
import com.example.pokemonappvk.data.response.handleApiReponse
import com.example.pokemonappvk.domain.model.PokemonDetails
import com.example.pokemonappvk.domain.model.resource.ResultState
import javax.inject.Inject

class PokemonDetailsDataSourceImpl @Inject constructor(
    private val api: PokemonDetailsApi
) : PokemonDetailsDataSource {
    override suspend fun getPokemonsDetails(name: String): ResultState<PokemonDetails> {
        return handleApiReponse(mapper = PokemonDetailsMapper) {
            api.getPokemonDetails(name)
        }
    }
}