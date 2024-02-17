package com.feature.pokemonslist.domain.repo

import com.feature.pokemonslist.domain.model.PokemonsListResponse

interface PokedexRepository {
    suspend fun getPokemonsList(limit: Int, offset: Int): PokemonsListResponse
}