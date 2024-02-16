package com.tematihonov.pokedexdecompose.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.tematihonov.pokedexdecompose.presentation.aboutapp.RealAboutAppComponent
import com.tematihonov.pokedexdecompose.presentation.pokemondetails.RealPokemonDetailsComponent
import com.tematihonov.pokedexdecompose.presentation.pokemonslist.RealPokemonListComponent
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext,
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.PokemonsList,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Configuration,
        context: ComponentContext,
    ): Child {
        return when (config) {
            Configuration.PokemonsList -> Child.PokemonsList(
                RealPokemonListComponent(componentContext = context,
                    onNavigateToDetailsScreen = { pokemonId ->
                        navigation.pushNew(Configuration.PokemonDetails(pokemonId))
                    })
            )

            is Configuration.PokemonDetails -> Child.PokemonDetails(
                RealPokemonDetailsComponent(
                    pokemonId = config.pokemonId,
                    componentContext = context,
                    backToPokemonsListScreen = {
                        navigation.pop()
                    }
                )
            )

            is Configuration.AboutApp -> Child.AboutApp(
                RealAboutAppComponent(componentContext = context,
                    onTabSelected = {
                        navigation.bringToFront(Configuration.AboutApp)
                    }
                )
            )
        }
    }

    sealed class Child {
        data class PokemonsList(val component: RealPokemonListComponent) : Child()
        data class PokemonDetails(val component: RealPokemonDetailsComponent) : Child()
        data class AboutApp(val component: RealAboutAppComponent): Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object PokemonsList : Configuration()

        @Serializable
        data class PokemonDetails(val pokemonId: Int) : Configuration()

        @Serializable
        data object AboutApp : Configuration()
    }

    fun onTabSelected(tab: Screen) {
        when (tab) {
            Screen.AboutApp -> {
                navigation.bringToFront(Configuration.AboutApp)
            }
            Screen.PokemonsList -> {
                navigation.pop()
            }
        }
    }
}