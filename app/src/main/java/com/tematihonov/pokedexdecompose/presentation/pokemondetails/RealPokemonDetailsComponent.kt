package com.tematihonov.pokedexdecompose.presentation.pokemondetails

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