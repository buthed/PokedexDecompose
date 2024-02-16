package com.core.common.components

sealed interface PokemonsListEvent {
    data class ClickButtonA(val pokemonName: String) : PokemonsListEvent
    data class UpdateText(val text: String): PokemonsListEvent
}