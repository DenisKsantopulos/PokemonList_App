package com.example.pokemonappvk.domain.di

import com.example.pokemonappvk.domain.usecase.detail.GetPokemonDetails
import com.example.pokemonappvk.domain.usecase.detail.GetPokemonDetailsUseCase
import com.example.pokemonappvk.domain.usecase.pokemons.GetPokemonsList
import com.example.pokemonappvk.domain.usecase.pokemons.GetPokemonsListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {


    @Binds
    abstract fun bindsGetPokemonsListUseCase(pokemonsListUseCase: GetPokemonsList): GetPokemonsListUseCase

    @Binds
    abstract fun bindsGetPokemonDetailsUseCase(pokemonDetailsUseCase: GetPokemonDetails): GetPokemonDetailsUseCase
}