package com.feature.pokemonslist.domain.useccases.local

import android.util.Log

class CreatePokemonsImageUrlUseCase {
    fun invoke(pokemonsUrl: String): String {
        val pokemonsId: Int = (pokemonsUrl.dropLast(1).takeLastWhile { it.isDigit() }).toInt()
        val pokemonImageUrl =
            if ((pokemonsId)<=999) { "%03d".format(pokemonsId) }
            else "%04d".format(pokemonsId)
        return "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${pokemonImageUrl}.png"
    }
}