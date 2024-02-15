package com.tematihonov.pokedexdecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.retainedComponent
import com.tematihonov.pokedexdecompose.navigation.RootComponent
import com.tematihonov.pokedexdecompose.presentation.MainScreen.MainScreen
import com.tematihonov.pokedexdecompose.presentation.core.ui.theme.PokedexDecomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = retainedComponent { RootComponent(it) }
        setContent {
            PokedexDecomposeTheme {
                MainScreen(root)
            }
        }
    }
}