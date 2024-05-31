package com.example.pokemonappvk.domain.repository.pokemons

import androidx.paging.PagingData
import com.example.pokemonappvk.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonsListRepository {
    suspend fun getPokemonsList(): Flow<PagingData<Pokemon>>
}