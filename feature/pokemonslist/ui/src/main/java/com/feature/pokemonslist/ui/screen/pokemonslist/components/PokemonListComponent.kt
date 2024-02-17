package com.feature.pokemonslist.ui.screen.pokemonslist.components

import com.feature.pokemonslist.ui.screen.pokemonslist.components.error.ErrorComponent
import com.feature.pokemonslist.ui.screen.pokemonslist.components.pokemonlistItem.PokemonListItemComponent
import com.feature.pokemonslist.ui.screen.pokemonslist.components.progressindicator.ProgressIndicatorComponent
import com.feature.pokemonslist.ui.screen.pokemonslist.components.topbar.TopBarComponent

interface PokemonListComponent {
    fun onEvent(event: PokemonsListEvent)

    val topBarComponent: TopBarComponent

    val errorComponent: ErrorComponent

    val progressIndicatorComponent: ProgressIndicatorComponent

    val pokemonListItemComponent: PokemonListItemComponent
}