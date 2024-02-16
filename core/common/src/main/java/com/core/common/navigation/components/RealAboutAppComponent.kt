package com.core.common.navigation.components

import com.arkivanov.decompose.ComponentContext
import com.core.common.navigation.Screen

class RealAboutAppComponent(
    componentContext: ComponentContext,
    private val onTabSelected: () -> Unit //TODO del?
) : ComponentContext by componentContext, AboutAppComponent {

    override fun onTabSelected(tab: Screen) {
        onTabSelected()
    }
}