package com.feature.pokemon_details.ui.screen.pokemondetails.components

import com.feature.pokemon_details.ui.screen.pokemondetails.components.error.ErrorComponent
import com.feature.pokemon_details.ui.screen.pokemondetails.components.pokemoncharacteristics.PokemonCharacteristicsComponent
import com.feature.pokemon_details.ui.screen.pokemondetails.components.progressindicator.ProgressIndicatorComponent
import com.feature.pokemon_details.ui.screen.pokemondetails.components.toolbar.ToolbarComponent

interface PokemonDetailsComponent {

    fun goBack()

    val toolbarComponent: ToolbarComponent

    val errorComponent: ErrorComponent

    val progressIndicatorComponent: ProgressIndicatorComponent

    val pokemonCharacteristicsComponent: PokemonCharacteristicsComponent
}