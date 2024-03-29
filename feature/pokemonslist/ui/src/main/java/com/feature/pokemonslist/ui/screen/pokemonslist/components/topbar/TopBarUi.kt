package com.feature.pokemonslist.ui.screen.pokemonslist.components.topbar

import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.core.common.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarUi(component: TopBarComponent) {
    CenterAlignedTopAppBar(title = {
        Text(text = stringResource(id = R.string.pokemons_list))
    })
}