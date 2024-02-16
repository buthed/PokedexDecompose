package com.tematihonov.pokedexdecompose.presentation.aboutapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.ComponentContext
import com.tematihonov.pokedexdecompose.navigation.PokemonsListEvent
import com.tematihonov.pokedexdecompose.navigation.Screen
import com.tematihonov.pokedexdecompose.presentation.pokemonslist.PokemonListComponent

class RealAboutAppComponent(
    componentContext: ComponentContext,
    private val onTabSelected: () -> Unit
) : ComponentContext by componentContext, AboutAppComponent {

    override fun onTabSelected(tab: Screen) {
        onTabSelected()
    }
}