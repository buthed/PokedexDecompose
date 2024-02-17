package com.feature.pokemon_details.ui.screen.pokemondetails.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.feature.pokemon_details.ui.screen.pokemondetails.components.error.RealErrorComponent
import com.feature.pokemon_details.ui.screen.pokemondetails.components.pokemoncharacteristics.RealPokemonCharacteristicsComponent
import com.feature.pokemon_details.ui.screen.pokemondetails.components.progressindicator.RealProgressIndicatorComponent
import com.feature.pokemon_details.ui.screen.pokemondetails.components.toolbar.RealToolbarComponent

class RealPokemonDetailsComponent (
    val pokemonName: String,
    componentContext: ComponentContext,
    private val backToPokemonsListScreen: () -> Unit
) : ComponentContext by componentContext, PokemonDetailsComponent {

    override fun goBack() {
        backToPokemonsListScreen()
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

    override val pokemonCharacteristicsComponent = RealPokemonCharacteristicsComponent(
        childContext(key = "pokemonCharacteristics")
    )
}