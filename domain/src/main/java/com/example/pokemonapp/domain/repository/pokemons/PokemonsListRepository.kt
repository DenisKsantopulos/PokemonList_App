package com.example.pokemonapp.domain.repository.pokemons

import androidx.paging.PagingData
import com.example.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonsListRepository {
    suspend fun getPokemonsList(): Flow<PagingData<Pokemon>>
}