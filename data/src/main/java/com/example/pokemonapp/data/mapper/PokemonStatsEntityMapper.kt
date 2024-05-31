package com.example.pokemonapp.data.mapper

import com.example.pokemonapp.data.entity.PokemonStatsEntity
import com.example.pokemonapp.data.entity.StatEntity
import com.example.pokemonapp.domain.model.PokemonStats
import com.example.pokemonapp.domain.model.Stat


object PokemonStatsEntityMapper : Mapper<PokemonStatsEntity, PokemonStats> {
    override fun map(data: PokemonStatsEntity): PokemonStats {
        return PokemonStats(
            baseStat = data.baseStat,
            effort = data.effort,
            stat = StatEntityMapper.map(data.stat)
        )
    }
}

object StatEntityMapper : Mapper<StatEntity, Stat> {
    override fun map(data: StatEntity): Stat {
        return Stat(
            name = data.name,
            url = data.url
        )
    }
}