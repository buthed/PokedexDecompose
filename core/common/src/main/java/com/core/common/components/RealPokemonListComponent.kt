package com.core.common.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.ComponentContext

class RealPokemonListComponent(
    componentContext: ComponentContext,
    private val onNavigateToDetailsScreen: (String) -> Unit,
) : ComponentContext by componentContext, PokemonListComponent {

    var pokemonName by mutableStateOf("")

    override fun onEvent(event: PokemonsListEvent) {
        when(event) {
            is PokemonsListEvent.ClickButtonA -> {
                onNavigateToDetailsScreen(pokemonName)
            }
            is PokemonsListEvent.UpdateText -> {
                pokemonName = event.text
            }
        }
    }
}