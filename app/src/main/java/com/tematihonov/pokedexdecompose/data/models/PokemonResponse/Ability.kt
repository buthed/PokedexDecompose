package com.tematihonov.pokedexdecompose.data.models.PokemonResponse

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)