package com.example.pokemonappvk.data.response

import com.example.pokemonappvk.data.entity.PokemonEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonsResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonEntity>,
)