package com.tematihonov.pokedexdecompose.presentation.pokemonslist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.ComponentContext
import com.tematihonov.pokedexdecompose.navigation.PokemonsListEvent

class RealPokemonListComponent(
    componentContext: ComponentContext,
    private val onNavigateToDetailsScreen: (Int) -> Unit,
) : ComponentContext by componentContext, PokemonListComponent {

    var pokemonsId by mutableIntStateOf(1)

    override fun onEvent(event: PokemonsListEvent) {
        onNavigateToDetailsScreen(pokemonsId)
    }

}