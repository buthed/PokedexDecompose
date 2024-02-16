package com.feature.pokemon_details.domain.model.PokemonResponse

data class PokemonResponse(
    val abilities: List<Ability>,
    val base_experience: Int,
    val height: Int,
    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val name: String = "Bulbasaur",
    val order: Int,
    val past_abilities: List<Any>,
    val stats: List<Stat>,
    val weight: Int
)