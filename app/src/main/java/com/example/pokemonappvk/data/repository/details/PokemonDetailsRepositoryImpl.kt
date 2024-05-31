package com.example.pokemonappvk.data.repository.details

import com.example.pokemonappvk.data.datasource.details.PokemonDetailsDataSource
import com.example.pokemonappvk.domain.model.PokemonDetails
import com.example.pokemonappvk.domain.model.resource.ResultState
import com.example.pokemonappvk.domain.repository.details.PokemonDetailsRepository
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(
    private val dataSource: PokemonDetailsDataSource
) : PokemonDetailsRepository {
    override suspend fun getPokemonDetails(name: String): ResultState<PokemonDetails> {
        return dataSource.getPokemonsDetails(name)
    }
}