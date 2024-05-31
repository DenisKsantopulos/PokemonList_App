package com.example.pokemonapp.domain.usecase.pokemons

import androidx.paging.PagingData
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repository.pokemons.PokemonsListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonsList @Inject constructor(
    private val pokempnsListRepository: PokemonsListRepository
) : GetPokemonsListUseCase {
    override suspend fun invoke(): Flow<PagingData<Pokemon>> {
        return pokempnsListRepository.getPokemonsList()
    }
}