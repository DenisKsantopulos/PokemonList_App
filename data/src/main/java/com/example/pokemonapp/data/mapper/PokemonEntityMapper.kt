package com.example.pokemonapp.data.mapper

import com.example.pokemonapp.data.entity.PokemonEntity
import com.example.pokemonapp.domain.model.Pokemon


object PokemonEntityMapper : Mapper<PokemonEntity, Pokemon> {
    override fun map(data: PokemonEntity): Pokemon = Pokemon(
        name = data.name,
        url = data.url
    )
}