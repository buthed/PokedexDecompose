package com.feature.pokemonslist.ui.screen.pokemonslist.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.feature.pokemonslist.ui.screen.pokemonslist.components.error.RealErrorComponent
import com.feature.pokemonslist.ui.screen.pokemonslist.components.pokemonlistItem.RealPokemonListItemComponent
import com.feature.pokemonslist.ui.screen.pokemonslist.components.progressindicator.RealProgressIndicatorComponent
import com.feature.pokemonslist.ui.screen.pokemonslist.components.toolbar.RealToolbarComponent

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

    override val toolbarComponent = RealToolbarComponent(
        childContext(key = "toolbar")
    )

    override val errorComponent = RealErrorComponent(
        childContext(key = "error")
    )

    override val progressIndicatorComponent = RealProgressIndicatorComponent(
        childContext(key = "progressIndicator")
    )

    override val pokemonListItemComponent = RealPokemonListItemComponent(
        childContext(key = "pokemonListItem")
    )
}