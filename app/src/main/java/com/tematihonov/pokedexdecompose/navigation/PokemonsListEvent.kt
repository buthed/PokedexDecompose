package com.tematihonov.pokedexdecompose.navigation

sealed interface PokemonsListEvent {
    data class ClickButtonA(val pokemonId: Int) : PokemonsListEvent
}