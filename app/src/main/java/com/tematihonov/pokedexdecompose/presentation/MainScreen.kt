package com.tematihonov.pokedexdecompose.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.tematihonov.pokedexdecompose.navigation.RootComponent
import com.tematihonov.pokedexdecompose.presentation.aboutapp.AboutAppUi
import com.tematihonov.pokedexdecompose.presentation.pokemondetails.PokemonDetailsUi
import com.tematihonov.pokedexdecompose.presentation.pokemonslist.PokemonsListUi

@Composable
fun MainScreen(root: RootComponent) {
    val childStack by root.childStack.subscribeAsState()
    Children(
        stack = childStack,
        //animation = stackAnimation(slide()) //TODO recheck
    ) { child ->
        when (val instance = child.instance) {
            is RootComponent.Child.PokemonsList -> PokemonsListUi(instance.component)
            is RootComponent.Child.PokemonDetails -> PokemonDetailsUi(pokemonsName = instance.component.pokemonName, component = instance.component)
            is RootComponent.Child.AboutApp -> AboutAppUi(instance.component)
        }
    }
}