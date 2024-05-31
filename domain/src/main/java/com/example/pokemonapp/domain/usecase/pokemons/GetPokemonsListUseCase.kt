package com.example.pokemonapp.domain.usecase.pokemons

import androidx.paging.PagingData
import com.example.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface GetPokemonsListUseCase {
    suspend fun invoke(): Flow<PagingData<Pokemon>>
}