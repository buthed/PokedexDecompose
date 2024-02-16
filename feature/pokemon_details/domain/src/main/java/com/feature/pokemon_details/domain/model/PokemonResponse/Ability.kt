package com.feature.pokemon_details.domain.model.PokemonResponse

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)