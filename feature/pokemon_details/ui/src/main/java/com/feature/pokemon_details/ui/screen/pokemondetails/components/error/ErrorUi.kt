package com.feature.pokemon_details.ui.screen.pokemondetails.components.error

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.core.common.R

@Composable
fun ErrorUi(errorComponent: ErrorComponent, errorMessage: String?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (errorMessage != null) Text(text = errorMessage, textAlign = TextAlign.Center)
        else Text(text = stringResource(id = R.string.error), textAlign = TextAlign.Center)
    }
}