package com.feature.pokemonslist.domain.useccases.local

class NumberFormatterUseCase {
    fun invoke(pokemonsUrl: String): String {
        val pokemonsId: Int = (pokemonsUrl.dropLast(1).takeLastWhile { it.isDigit() }).toInt()
        return "№%04d".format(pokemonsId)
    }
}