package com.feature.pokemon_details.ui.screen.pokemondetails

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.core.common.R
import com.core.common.navigation.components.PokemonDetailsComponent
import com.feature.pokemon_details.ui.screen.pokemondetails.components.TopAppBarPokemonDetails

@Composable
fun PokemonDetailsUi(pokemonsName: String, component: PokemonDetailsComponent) {
    Log.d("GGG", "opened PokemonDetailsViewModel pokemonsName - ${pokemonsName}")
    val viewModel = hiltViewModel<PokemonDetailsViewModel>()
    Scaffold(
        topBar = {
            TopAppBarPokemonDetails() {
                component.goBack()
            }
        }
    ) { paddingValues ->
        when (val resultPokemonsList = viewModel.pokemon.value) {
            is com.core.common.utils.Resource.Error -> {
                //TODO()
            }
            is com.core.common.utils.Resource.Loading -> {
                //TODO()
            }
            is com.core.common.utils.Resource.Success -> {
                resultPokemonsList.data?.let { pokemonDetails ->
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(top = paddingValues.calculateTopPadding())) {
                        AsyncImage(
                            model = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                            //.fillMaxWidth(),
                        )
                        Row {
                            Text(text ="${pokemonDetails.name}") //TODO add
                            Text(text = "#00${pokemonDetails.id}") //TODO add
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
        }
    }
    LaunchedEffect(true) {
        viewModel.loadPokemonInfo(pokemonsName)
    }
}

class FakePokemonDetailsComponent(): PokemonDetailsComponent {
    override fun goBack() {
        TODO("Not yet implemented")
    }

}


@Preview(showSystemUi = true)
@Composable
fun PokemonDetailsUiPreview() {
    PokemonDetailsUi("Bulbasaur", FakePokemonDetailsComponent())
}