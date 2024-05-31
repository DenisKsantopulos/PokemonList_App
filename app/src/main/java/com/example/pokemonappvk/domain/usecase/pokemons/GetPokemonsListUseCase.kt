package com.example.pokemonappvk.domain.usecase.pokemons

import androidx.paging.PagingData
import com.example.pokemonappvk.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface GetPokemonsListUseCase {
    suspend fun invoke(): Flow<PagingData<Pokemon>>
}