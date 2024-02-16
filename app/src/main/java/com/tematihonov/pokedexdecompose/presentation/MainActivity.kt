package com.tematihonov.pokedexdecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.retainedComponent
import com.tematihonov.pokedexdecompose.navigation.BottomNavigationBar
import com.tematihonov.pokedexdecompose.navigation.RootComponent
import com.tematihonov.pokedexdecompose.navigation.Screen
import com.tematihonov.pokedexdecompose.presentation.core.ui.theme.PokedexDecomposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = retainedComponent { RootComponent(it) }

        val bottomBarItems = listOf(
            Screen.PokemonsList,
            Screen.AboutApp
        )

        setContent {
            PokedexDecomposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar =  {
                        BottomNavigationBar(items = bottomBarItems) { screen ->
                            root.onTabSelected(screen)
                        }
                    }
                ) {
                    Box(modifier = Modifier.padding(paddingValues = it)) {
                        MainScreen(root)
                    }
                }
            }
        }
    }
}