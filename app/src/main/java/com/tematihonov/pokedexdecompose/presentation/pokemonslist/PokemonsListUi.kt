package com.tematihonov.pokedexdecompose.presentation.pokemonslist

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tematihonov.pokedexdecompose.R
import com.tematihonov.pokedexdecompose.navigation.PokemonsListEvent
import com.tematihonov.pokedexdecompose.presentation.appcomponents.TopAppBarDefault
import com.tematihonov.pokedexdecompose.presentation.pokemonslist.components.PokemonsListItem
import com.tematihonov.pokedexdecompose.utils.Resource

@Composable
fun PokemonsListUi(component: PokemonListComponent) {
    val viewModel = hiltViewModel<PokemonsListViewModel>()
    val pokemonsArrayList by remember { viewModel.pokemonsArrayList }
    val endReached by remember { viewModel.endReached }

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
                if (viewModel.pokemonsArrayList.value.isNotEmpty()) {
                    LazyColumn(modifier = Modifier.padding(top = paddingValues.calculateTopPadding(), bottom = 25.dp)) {
                        val itemCount = if(pokemonsArrayList.size % 2 == 0) {
                            pokemonsArrayList.size / 2
                        } else {
                            pokemonsArrayList.size / 2 + 1
                        }
                        items(itemCount) {
                            if (it >= itemCount -1 && !endReached) {
                                viewModel.loadPokemonsList()
                            }
                            PokemonsListItem(rowIndex = it, entries = pokemonsArrayList) {
                                component.onEvent(PokemonsListEvent.UpdateText(pokemonsArrayList[it].name))
                                component.onEvent(PokemonsListEvent.ClickButtonA(pokemonsArrayList[it].name))
                            }
                            Log.d("GGG", "item count: $itemCount, it: $it, endReached: $endReached")
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