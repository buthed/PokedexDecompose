package com.feature.pokemon_details.domain.usecases.local

class NumberFormatterUseCase {
    fun invoke(pokemonsId: Int): String {
        return "№%04d".format(pokemonsId)
    }
}