package com.feature.pokemon_details.ui.screen.pokemondetails.components.pokemoncharacteristics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.core.common.R
import com.feature.pokemon_details.domain.model.PokemonResponse.PokemonResponse

@Composable
fun PokemonCharacteristicUi(
    pokemonCharacteristicsComponent: PokemonCharacteristicsComponent,
    pokemonDetails: PokemonResponse,
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Gray),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(id = R.string.height))
            Text(text = "${pokemonDetails.height / 10}.${pokemonDetails.height % 10} м")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(id = R.string.height))
            Text(text = "${pokemonDetails.weight / 10} кг")
        }
    }
}