package com.feature.about_app.ui.screen.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.core.common.navigation.Screen
import com.feature.about_app.ui.screen.components.topappbar.RealTopAppBarComponent

class RealAboutAppComponent(
    componentContext: ComponentContext,
    private val onTabSelected: () -> Unit //TODO del?
) : ComponentContext by componentContext, AboutAppComponent {

    override fun onTabSelected(tab: Screen) {
        onTabSelected()
    }

    override val topAppBarComponent = RealTopAppBarComponent(
        childContext(key = "topAppBar")
    )
}