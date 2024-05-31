package com.example.pokemonapp.data.mapper

interface Mapper<Entity, Domain> {
    fun map(data: Entity): Domain
}