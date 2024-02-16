package com.tematihonov.pokedexdecompose.domain.repository

import com.tematihonov.pokedexdecompose.data.models.PokemonResponse.PokemonResponse
import com.tematihonov.pokedexdecompose.data.models.PokemonsListResponse.PokemonsListResponse

interface NetworkRepository {

    suspend fun getPokemonsList(): PokemonsListResponse

    suspend fun getPokemonDetails(name: String): PokemonResponse
}