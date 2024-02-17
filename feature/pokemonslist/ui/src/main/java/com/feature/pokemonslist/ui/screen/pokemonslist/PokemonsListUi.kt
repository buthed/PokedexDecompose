package com.feature.pokemonslist.ui.screen.pokemonslist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.core.common.utils.Resource
import com.feature.pokemonslist.ui.screen.pokemonslist.components.PokemonListComponent
import com.feature.pokemonslist.ui.screen.pokemonslist.components.PokemonsListEvent
import com.feature.pokemonslist.ui.screen.pokemonslist.components.error.ErrorUi
import com.feature.pokemonslist.ui.screen.pokemonslist.components.pokemonlistItem.PokemonsListItemUi
import com.feature.pokemonslist.ui.screen.pokemonslist.components.progressindicator.ProgressIndicatorUi
import com.feature.pokemonslist.ui.screen.pokemonslist.components.topbar.TopBarUi

@Composable
fun PokemonsListUi(component: PokemonListComponent) {
    val viewModel = hiltViewModel<PokemonsListViewModel>()
    val pokemonsArrayList by remember { viewModel.pokemonsArrayList }
    val endReached by remember { viewModel.endReached }

    Scaffold(
        topBar = {
            TopBarUi(component.topBarComponent)
        }
    ) { paddingValues ->

        when (val resultPokemonsList = viewModel.pokemonsList.value) {
            is Resource.Error -> {
                ErrorUi(component.errorComponent, resultPokemonsList.message)
            }

            is Resource.Loading -> {
                ProgressIndicatorUi(component.progressIndicatorComponent)
            }

            is Resource.Success -> {
                if (viewModel.pokemonsArrayList.value.isNotEmpty()) {
                    LazyColumn(modifier = Modifier.padding(top = paddingValues.calculateTopPadding(), bottom = 10.dp)) {
                        val itemCount = if(pokemonsArrayList.size % 2 == 0) { pokemonsArrayList.size / 2
                        } else { pokemonsArrayList.size / 2 + 1 }

                        items(itemCount) {
                            if (it >= itemCount -1 && !endReached) { viewModel.loadPokemonsList() }

                            PokemonsListItemUi(
                                pokemonListItemComponent = component.pokemonListItemComponent,
                                rowIndex = it,
                                entries = pokemonsArrayList,
                                imageUrl = viewModel.setNewPokemonImageUrl(pokemonsArrayList[it].url),
                                number = viewModel.setNewPokemonNumber(pokemonsArrayList[it].url)
                            ) {
                                component.onEvent(PokemonsListEvent.UpdateText(pokemonsArrayList[it].name))
                                component.onEvent(PokemonsListEvent.ClickButtonA(pokemonsArrayList[it].name))
                            }
                        }
                    }
                }
            }
         }
    }
}