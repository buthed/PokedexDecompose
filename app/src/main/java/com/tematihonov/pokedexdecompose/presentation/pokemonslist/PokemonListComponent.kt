package com.tematihonov.pokedexdecompose.presentation.pokemonslist

import com.tematihonov.pokedexdecompose.navigation.PokemonsListEvent

interface PokemonListComponent {

    fun onEvent(event: PokemonsListEvent)
}