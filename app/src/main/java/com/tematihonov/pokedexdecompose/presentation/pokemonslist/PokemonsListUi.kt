package com.tematihonov.pokedexdecompose.presentation.pokemonslist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.tematihonov.pokedexdecompose.R
import com.tematihonov.pokedexdecompose.navigation.PokemonsListEvent
import com.tematihonov.pokedexdecompose.presentation.appcomponents.TopAppBarDefault
import com.tematihonov.pokedexdecompose.presentation.pokemonslist.components.PokemonsListItem
import com.tematihonov.pokedexdecompose.utils.Resource

@Composable
fun PokemonsListUi(component: PokemonListComponent) {
    val viewModel = hiltViewModel<PokemonsListViewModel>()
    when (val resultPokemonsList = viewModel.pokemonsList.value) {
        is Resource.Error -> {
            //TODO()
        }

        is Resource.Loading -> {
            //TODO()
        }

        is Resource.Success -> {
            Scaffold(
                topBar = {
                    TopAppBarDefault(stringResource(id = R.string.pokemons_list))
                }
            ) { paddingValues ->
                resultPokemonsList.data?.let { pokemonsList ->
                    LazyColumn(modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {
                        items(pokemonsList) { pokemon ->
                            PokemonsListItem(pokemonName = pokemon.name) {
                                component.onEvent(PokemonsListEvent.UpdateText(pokemon.name))
                                component.onEvent(PokemonsListEvent.ClickButtonA(pokemon.name))
                            }
                        }
                    }
                }
            }
        }
    }
}

class FakePokemonListComponent() : PokemonListComponent {
    override fun onEvent(event: PokemonsListEvent) {
        TODO("Not yet implemented")
    }

}

@Preview(showSystemUi = true)
@Composable
fun PokemonsListPreview() {
    PokemonsListUi(FakePokemonListComponent())
}