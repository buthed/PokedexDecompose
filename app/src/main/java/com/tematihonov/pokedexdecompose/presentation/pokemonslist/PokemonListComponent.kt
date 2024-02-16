package com.tematihonov.pokedexdecompose.presentation.pokemonslist

import com.tematihonov.pokedexdecompose.navigation.PokemonsListEvent
import com.tematihonov.pokedexdecompose.navigation.Screen

interface PokemonListComponent {

    fun onEvent(event: PokemonsListEvent)

}