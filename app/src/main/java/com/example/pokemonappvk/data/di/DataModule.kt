package com.example.pokemonappvk.data.di

import com.example.pokemonappvk.data.datasource.details.PokemonDetailsDataSource
import com.example.pokemonappvk.data.datasource.details.PokemonDetailsDataSourceImpl
import com.example.pokemonappvk.data.datasource.pokemons.PokemonsListDataSource
import com.example.pokemonappvk.data.datasource.pokemons.PokemonsListDataSourceImpl
import com.example.pokemonappvk.data.repository.details.PokemonDetailsRepositoryImpl
import com.example.pokemonappvk.data.repository.pokemons.PokemonsListRepositoryImpl
import com.example.pokemonappvk.domain.repository.details.PokemonDetailsRepository
import com.example.pokemonappvk.domain.repository.pokemons.PokemonsListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsPokemonsListDataSource(pokemonsListDataSource: PokemonsListDataSourceImpl)
            : PokemonsListDataSource

    @Binds
    abstract fun bindsPokemonsListRepository(pokemonsListRepository: PokemonsListRepositoryImpl)
            : PokemonsListRepository


    @Binds
    abstract fun bindsPokemonDetailsDataSource(pokemonDetailsDataSource: PokemonDetailsDataSourceImpl)
            : PokemonDetailsDataSource

    @Binds
    abstract fun bindsPokemonDetailsRepository(pokemonDetailsRepository: PokemonDetailsRepositoryImpl)
            : PokemonDetailsRepository
}