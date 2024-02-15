package com.tematihonov.pokedexdecompose.presentation.MainScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.tematihonov.pokedexdecompose.navigation.RootComponent
import com.tematihonov.pokedexdecompose.presentation.pokemondetails.PokemonDetailsUi
import com.tematihonov.pokedexdecompose.presentation.pokemonslist.PokemonListComponent
import com.tematihonov.pokedexdecompose.presentation.pokemonslist.PokemonsListUi


@Composable
fun MainScreen(root: RootComponent) {
    val childStack by root.childStack.subscribeAsState()
    Children(
        stack = childStack,
        animation = stackAnimation(slide())
    ) { child ->
        when (val instance = child.instance) {
            is RootComponent.Child.PokemonsList -> PokemonsListUi(instance.component)
            is RootComponent.Child.PokemonDetails -> PokemonDetailsUi(pokemonsId = 1, component = instance.component)
        }
    }
}