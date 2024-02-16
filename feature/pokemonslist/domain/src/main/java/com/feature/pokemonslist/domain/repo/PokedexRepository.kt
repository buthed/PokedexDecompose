package com.feature.pokemonslist.domain.repo

import com.feature.pokemonslist.domain.model.Result

interface PokedexRepository {
    suspend fun getPokemonsList(limit: Int, offset: Int): List<Result>
}