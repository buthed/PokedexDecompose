package com.feature.pokemonslist.ui.screen.pokemonslist.components.progressindicator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProgressIndicatorUi(progressIndicatorComponent: ProgressIndicatorComponent) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(modifier = Modifier.size(100.dp),
            color = Color.Yellow)
    }
}