package com.tematihonov.pokedexdecompose.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.feature.about_app.ui.screen.AboutAppUi
import com.tematihonov.pokedexdecompose.navigation.RootComponent
import com.feature.pokemon_details.ui.screen.pokemondetails.PokemonDetailsUi
import com.feature.pokemonslist.ui.screen.pokemonslist.PokemonsListUi

@Composable
fun MainScreen(root: RootComponent) {
    val childStack by root.childStack.subscribeAsState()
    Children(
        stack = childStack,
    ) { child ->
        when (val instance = child.instance) {
            is RootComponent.Child.PokemonsList -> PokemonsListUi(
                instance.component
            )
            is RootComponent.Child.PokemonDetails -> PokemonDetailsUi(
                pokemonsName = instance.component.pokemonName,
                component = instance.component
            )
            is RootComponent.Child.AboutApp -> AboutAppUi(instance.component)
        }
    }
}