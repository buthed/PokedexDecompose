package com.core.common.components

import com.arkivanov.decompose.ComponentContext

class RealPokemonDetailsComponent (
    val pokemonName: String,
    componentContext: ComponentContext,
    private val backToPokemonsListScreen: () -> Unit
) : ComponentContext by componentContext, PokemonDetailsComponent {

    override fun goBack() {
        backToPokemonsListScreen()
    }
}