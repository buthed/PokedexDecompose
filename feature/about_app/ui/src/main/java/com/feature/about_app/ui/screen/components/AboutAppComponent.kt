package com.feature.about_app.ui.screen.components

import com.core.common.navigation.Screen
import com.feature.about_app.ui.screen.components.topappbar.TopAppBarComponent

interface AboutAppComponent {

    fun onTabSelected(tab: Screen)

    val topAppBarComponent: TopAppBarComponent
}