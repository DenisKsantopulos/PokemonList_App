package com.example.pokemonapp.domain.di

import com.example.pokemonapp.domain.usecase.detail.GetPokemonDetails
import com.example.pokemonapp.domain.usecase.detail.GetPokemonDetailsUseCase
import com.example.pokemonapp.domain.usecase.pokemons.GetPokemonsList
import com.example.pokemonapp.domain.usecase.pokemons.GetPokemonsListUseCase
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