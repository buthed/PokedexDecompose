package com.feature.pokemon_details.domain.usecases.local

class CreatePokemonsImageUrlUseCase {
    fun invoke(pokemonsId: Int): String {
        val pokemonImageUrl =
            if ((pokemonsId)<=999) { "%03d".format(pokemonsId) }
            else "%04d".format(pokemonsId)
        return "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${pokemonImageUrl}.png"
    }
}