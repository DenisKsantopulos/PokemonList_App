package com.example.pokemonapp.data.repository.details


import com.example.pokemonapp.data.datasource.details.PokemonDetailsDataSource
import com.example.pokemonapp.domain.model.PokemonDetails
import com.example.pokemonapp.domain.model.resource.ResultState
import com.example.pokemonapp.domain.repository.details.PokemonDetailsRepository
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(
    private val dataSource: PokemonDetailsDataSource
) : PokemonDetailsRepository {
    override suspend fun getPokemonDetails(name: String): ResultState<PokemonDetails> {
        return dataSource.getPokemonsDetails(name)
    }
}