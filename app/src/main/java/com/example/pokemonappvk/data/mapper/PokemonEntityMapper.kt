package com.example.pokemonappvk.data.mapper

import com.example.pokemonappvk.data.entity.PokemonEntity
import com.example.pokemonappvk.domain.model.Pokemon

object PokemonEntityMapper : Mapper<PokemonEntity, Pokemon> {
    override fun map(data: PokemonEntity): Pokemon = Pokemon(
        name = data.name,
        url = data.url
    )
}