package com.example.pokemonappvk.domain.usecase.pokemons

import androidx.paging.PagingData
import com.example.pokemonappvk.domain.model.Pokemon
import com.example.pokemonappvk.domain.repository.pokemons.PokemonsListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonsList @Inject constructor(
    private val pokempnsListRepository: PokemonsListRepository
) : GetPokemonsListUseCase {
    override suspend fun invoke(): Flow<PagingData<Pokemon>> {
        return pokempnsListRepository.getPokemonsList()
    }
}