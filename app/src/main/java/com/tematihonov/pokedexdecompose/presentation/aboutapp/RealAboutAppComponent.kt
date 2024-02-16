package com.tematihonov.pokedexdecompose.presentation.aboutapp

import com.arkivanov.decompose.ComponentContext
import com.tematihonov.pokedexdecompose.navigation.Screen

class RealAboutAppComponent(
    componentContext: ComponentContext,
    private val onTabSelected: () -> Unit //TODO del?
) : ComponentContext by componentContext, AboutAppComponent {

    override fun onTabSelected(tab: Screen) {
        onTabSelected()
    }
}