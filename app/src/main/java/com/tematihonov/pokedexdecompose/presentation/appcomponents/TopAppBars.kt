package com.tematihonov.pokedexdecompose.presentation.appcomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.pokedexdecompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDefault(title: String) {
    CenterAlignedTopAppBar(title = {
        Text(text = title)
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPokemonDetails(backButton: () -> Unit) {
    CenterAlignedTopAppBar(title = {},
        navigationIcon = { Icon(painter = painterResource(id = R.drawable.icon_arrow_back), contentDescription = "",
            modifier = Modifier.clickable(onClick = backButton)) })
}


@Preview(showSystemUi = true)
@Composable
fun TopAppBarsPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        TopAppBarDefault(stringResource(id = R.string.pokemons_list))
        TopAppBarPokemonDetails() {}
    }
}