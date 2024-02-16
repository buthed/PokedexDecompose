package com.core.common.navigation

import com.core.common.R

sealed class Screen(
    val name: Int
) {
    object PokemonsList: Screen(name = R.string.pokemons_list)
    object AboutApp: Screen(name = R.string.about_app)
}