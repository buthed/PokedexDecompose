package com.feature.pokemon_details.ui.screen.pokemondetails.components.topbar

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.core.common.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarUi(component: TopBarComponent, backButton: () -> Unit) {
    CenterAlignedTopAppBar(title = {},
        navigationIcon = { Icon(painter = painterResource(id = R.drawable.icon_arrow_back), contentDescription = "",
            modifier = Modifier.clickable(onClick = backButton)) })
}