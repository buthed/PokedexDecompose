package com.tematihonov.pokedexdecompose.presentation.pokemondetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tematihonov.pokedexdecompose.R
import com.tematihonov.pokedexdecompose.presentation.appcomponents.TopAppBarPokemonDetails

@Composable
fun PokemonDetailsUi() {
    Scaffold(
        topBar = {
            TopAppBarPokemonDetails() {
                // TODO add
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(top = paddingValues.calculateTopPadding())) {
            AsyncImage(
                model = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    //.fillMaxWidth(),
            )
            Row {
                Text(text = "Bulbasaur")
                Text(text = "#0001")
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = stringResource(id = R.string.height))
                    Text(text = "0.3 м")
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = stringResource(id = R.string.height))
                    Text(text = "6 кг")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PokemonDetailsUiPreview() {
    PokemonDetailsUi()
}