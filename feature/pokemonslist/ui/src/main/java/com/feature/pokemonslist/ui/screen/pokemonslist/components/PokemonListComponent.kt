package com.feature.pokemonslist.ui.screen.pokemonslist.components

import com.feature.pokemonslist.ui.screen.pokemonslist.components.error.ErrorComponent
import com.feature.pokemonslist.ui.screen.pokemonslist.components.pokemonlistItem.PokemonListItemComponent
import com.feature.pokemonslist.ui.screen.pokemonslist.components.progressindicator.ProgressIndicatorComponent
import com.feature.pokemonslist.ui.screen.pokemonslist.components.toolbar.ToolbarComponent


interface PokemonListComponent {
    fun onEvent(event: PokemonsListEvent)

    val toolbarComponent: ToolbarComponent

    val errorComponent: ErrorComponent

    val progressIndicatorComponent: ProgressIndicatorComponent

    val pokemonListItemComponent: PokemonListItemComponent
}