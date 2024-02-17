package com.feature.pokemon_details.ui.screen.pokemondetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.core.common.utils.Resource
import com.feature.pokemon_details.ui.screen.pokemondetails.components.PokemonDetailsComponent
import com.feature.pokemon_details.ui.screen.pokemondetails.components.error.ErrorUi
import com.feature.pokemon_details.ui.screen.pokemondetails.components.pokemoncharacteristics.PokemonCharacteristicUi
import com.feature.pokemon_details.ui.screen.pokemondetails.components.progressindicator.ProgressIndicatorUi
import com.feature.pokemon_details.ui.screen.pokemondetails.components.topbar.TopBarUi

@Composable
fun PokemonDetailsUi(pokemonsName: String, component: PokemonDetailsComponent) {
    val viewModel = hiltViewModel<PokemonDetailsViewModel>()
    Scaffold(
        topBar = {
            TopBarUi(component.topBarComponent) { component.goBack() }
        }
    ) { paddingValues ->
        when (val resultPokemonsList = viewModel.pokemon.value) {
            is Resource.Error -> {
                ErrorUi(component.errorComponent, resultPokemonsList.message)
            }

            is Resource.Loading -> {
                ProgressIndicatorUi(component.progressIndicatorComponent)
            }

            is Resource.Success -> {
                resultPokemonsList.data?.let { pokemonDetails ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = paddingValues.calculateTopPadding()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        AsyncImage(
                            model = viewModel.setNewPokemonImageUrl(pokemonDetails.id),
                            contentDescription = null,
                            modifier = Modifier.size(200.dp),
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                            Text(text = pokemonDetails.name.replaceFirstChar { it.uppercase() })
                            Text(text = viewModel.setNewPokemonNumber(pokemonDetails.id))
                        }
                        PokemonCharacteristicUi(
                            pokemonCharacteristicsComponent = component.pokemonCharacteristicsComponent,
                            pokemonDetails = pokemonDetails
                        )
                    }
                }
            }
        }
    }
    LaunchedEffect(true) {
        viewModel.loadPokemonInfo(pokemonsName)
    }
}

//class FakePokemonDetailsComponent() : PokemonDetailsComponent {
//    override fun goBack() {
//        TODO("Not yet implemented")
//    }
//
//}
//
//
//@Preview(showSystemUi = true)
//@Composable
//fun PokemonDetailsUiPreview() {
//    PokemonDetailsUi("Bulbasaur", FakePokemonDetailsComponent())
//}