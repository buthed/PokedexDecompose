package com.tematihonov.pokedexdecompose.presentation.pokemonslist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tematihonov.pokedexdecompose.R
import com.tematihonov.pokedexdecompose.navigation.PokemonsListEvent
import com.tematihonov.pokedexdecompose.presentation.appcomponents.TopAppBarDefault
import com.tematihonov.pokedexdecompose.presentation.pokemonslist.components.PokemonsListItem

@Composable
fun PokemonsListUi(component: PokemonListComponent) {
    Scaffold(
        topBar = {
            TopAppBarDefault(stringResource(id = R.string.pokemons_list))
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {
            items(5) {
                PokemonsListItem() {
                    component.onEvent(PokemonsListEvent.ClickButtonA(1))
                }
            }
        }
    }
}

class FakePokemonListComponent(): PokemonListComponent {
    override fun onEvent(event: PokemonsListEvent) {
        TODO("Not yet implemented")
    }

}

@Preview(showSystemUi = true)
@Composable
fun PokemonsListPreview() {
    PokemonsListUi(FakePokemonListComponent())
}