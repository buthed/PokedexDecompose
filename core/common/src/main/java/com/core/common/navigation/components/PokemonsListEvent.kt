package com.core.common.navigation.components

sealed interface PokemonsListEvent {
    data class ClickButtonA(val pokemonName: String) : PokemonsListEvent
    data class UpdateText(val text: String): PokemonsListEvent
}