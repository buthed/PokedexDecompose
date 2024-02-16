package com.core.network.models.PokemonResponse

data class PokemonNetwork(
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
    val past_types: List<Any>,
    val stats: List<Stat>,
    val weight: Int
)