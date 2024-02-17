package com.feature.pokemonslist.domain.repo

import com.feature.pokemonslist.domain.model.PokemonsListResponse
import com.feature.pokemonslist.domain.model.Result

interface PokedexRepository {
    suspend fun getPokemonsList(limit: Int, offset: Int): PokemonsListResponse
}