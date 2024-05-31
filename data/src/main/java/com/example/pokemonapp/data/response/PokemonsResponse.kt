package com.example.pokemonapp.data.response

import com.example.pokemonapp.data.entity.PokemonEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonsResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonEntity>,
)