package com.tematihonov.pokedexdecompose.presentation.pokemonslist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tematihonov.pokedexdecompose.R
import com.tematihonov.pokedexdecompose.presentation.appcomponents.TopAppBarDefault
import com.tematihonov.pokedexdecompose.presentation.pokemonslist.components.PokemonsListItem

@Composable
fun PokemonsList() {
    Scaffold(
        topBar = {
            TopAppBarDefault(stringResource(id = R.string.pokemons_list))
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {
            items(5) {
                PokemonsListItem()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PokemonsListPreview() {
    PokemonsList()
}