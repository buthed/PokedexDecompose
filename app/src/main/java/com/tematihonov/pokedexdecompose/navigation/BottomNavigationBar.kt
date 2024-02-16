package com.tematihonov.pokedexdecompose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar(
    items: List<Screen>,
    modifier: Modifier = Modifier,
    onTabSelected: (Screen) -> Unit
) {

    NavigationBar(
        modifier = modifier,
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = true,
                onClick = { onTabSelected(item) },
                icon = {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = stringResource(id = item.name))
                    }
                },
            )
        }
    }
}