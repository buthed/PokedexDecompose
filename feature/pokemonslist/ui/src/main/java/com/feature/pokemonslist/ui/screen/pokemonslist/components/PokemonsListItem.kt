package com.feature.pokemonslist.ui.screen.pokemonslist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.feature.pokemonslist.domain.model.Result

@Composable
fun PokemonsListItem(
    rowIndex: Int,
    entries: List<Result>,
    selectnewPokemon: () ->Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable(onClick = selectnewPokemon),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AsyncImage(
            model = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
        )
        Column {
            Text(text = entries[rowIndex].name)
            Text(text = entries[rowIndex].url.dropLast(1).takeLastWhile { it.isDigit() }) //TODO refactor
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PokemonsListItemPreview() {
    PokemonsListItem(1, emptyList()){}
}