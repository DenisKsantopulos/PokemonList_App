package com.example.pokemonappvk.data.entity

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class PokemonEntity(
    val name: String,
    val url: String,
)
