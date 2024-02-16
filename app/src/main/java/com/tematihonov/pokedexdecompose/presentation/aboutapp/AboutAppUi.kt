package com.tematihonov.pokedexdecompose.presentation.aboutapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tematihonov.pokedexdecompose.R
import com.tematihonov.pokedexdecompose.navigation.PokemonsListEvent
import com.tematihonov.pokedexdecompose.navigation.Screen
import com.tematihonov.pokedexdecompose.presentation.appcomponents.TopAppBarDefault
import com.tematihonov.pokedexdecompose.presentation.pokemonslist.PokemonListComponent

@Composable
fun AboutAppUi(component: AboutAppComponent) {
    Scaffold(
        topBar = {
            TopAppBarDefault(stringResource(id = R.string.about_app))
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding()),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(id = R.string.about_app))
        }
    }
}

class FakeAboutAppComponent(): AboutAppComponent {
    override fun onTabSelected(tab: Screen) {
        TODO("Not yet implemented")
    }
}


@Preview(showSystemUi = true)
@Composable
fun AboutAppUiPreview() {
    AboutAppUi(FakeAboutAppComponent())
}