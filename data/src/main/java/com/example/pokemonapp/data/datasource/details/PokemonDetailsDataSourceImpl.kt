package com.example.pokemonapp.data.datasource.details


import com.example.pokemonapp.data.api.PokemonDetailsApi
import com.example.pokemonapp.data.mapper.PokemonDetailsMapper
import com.example.pokemonapp.data.response.handleApiReponse
import com.example.pokemonapp.domain.model.PokemonDetails
import com.example.pokemonapp.domain.model.resource.ResultState
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