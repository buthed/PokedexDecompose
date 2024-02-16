package com.tematihonov.pokedexdecompose.navigation

import androidx.compose.ui.res.stringResource
import com.tematihonov.pokedexdecompose.R

sealed class Screen(
    val name: Int
) {
    object PokemonsList: Screen(name = R.string.pokemons_list)
    object AboutApp: Screen(name = R.string.about_app)
}