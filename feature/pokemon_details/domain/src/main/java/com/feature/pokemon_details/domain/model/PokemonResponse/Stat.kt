package com.feature.pokemon_details.domain.model.PokemonResponse

data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: StatX
)