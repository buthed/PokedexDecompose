package com.feature.pokemonslist.ui.screen.pokemonslist.components.pokemonlistItem

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.feature.pokemonslist.domain.model.Result

@Composable
fun PokemonsListItemUi(
    pokemonListItemComponent: PokemonListItemComponent,
    rowIndex: Int,
    entries: List<Result>,
    imageUrl: String,
    number: String,
    selectnewPokemon: () -> Unit,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.Gray)
            .clickable(onClick = selectnewPokemon),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
        )
        Column {
            Text(text = entries[rowIndex].name.replaceFirstChar { it.uppercase() })
            Text(text = number)
        }
    }
}

class FakePokemonListComponent() : PokemonListItemComponent {

}

@Preview(showSystemUi = true)
@Composable
fun PokemonsListItemPreview() {
    PokemonsListItemUi(FakePokemonListComponent(), 1, emptyList(), "", "1") {}
}