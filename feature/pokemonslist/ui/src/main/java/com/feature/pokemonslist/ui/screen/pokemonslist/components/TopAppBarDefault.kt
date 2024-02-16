package com.feature.pokemonslist.ui.screen.pokemonslist.components

import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.core.common.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDefault(title: String) {
    CenterAlignedTopAppBar(title = {
        Text(text = title)
    })
}


@Preview(showSystemUi = true)
@Composable
fun TopAppBarsPreview() {
    TopAppBarDefault(stringResource(id = R.string.pokemons_list))

}