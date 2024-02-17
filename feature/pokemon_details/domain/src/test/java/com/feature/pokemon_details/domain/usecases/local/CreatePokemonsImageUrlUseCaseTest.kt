package com.feature.pokemon_details.domain.usecases.local

import org.junit.Test
import org.junit.Assert.*

class CreatePokemonsImageUrlUseCaseTest {

    @Test
    fun test1() {
        val pokemonsId = 1
        val expected = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"

        val pokemonImageUrl =
            if ((pokemonsId)<=999) { "%03d".format(pokemonsId) }
            else "%04d".format(pokemonsId)
        val pokemonUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${pokemonImageUrl}.png"

        val result = pokemonUrl.equals(expected)
        assertEquals(true, result)
    }

    @Test
    fun test2() {
        val pokemonsId = 21
        val expected = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/021.png"
        val pokemonImageUrl =
            if ((pokemonsId)<=999) { "%03d".format(pokemonsId) }
            else "%04d".format(pokemonsId)
        val pokemonUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${pokemonImageUrl}.png"

        val result = pokemonUrl.equals(expected)
        assertEquals(true, result)
    }

    @Test
    fun test3() {
        val pokemonsId = 333
        val expected = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/333.png"
        val pokemonImageUrl =
            if ((pokemonsId)<=999) { "%03d".format(pokemonsId) }
            else "%04d".format(pokemonsId)
        val pokemonUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${pokemonImageUrl}.png"

        val result = pokemonUrl.equals(expected)
        assertEquals(true, result)
    }

    @Test
    fun test4() {
        val pokemonsId = 1010
        val expected = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/1010.png"
        val pokemonImageUrl =
            if ((pokemonsId)<=999) { "%03d".format(pokemonsId) }
            else "%04d".format(pokemonsId)
        val pokemonUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${pokemonImageUrl}.png"

        val result = pokemonUrl.equals(expected)
        assertEquals(true, result)
    }
}