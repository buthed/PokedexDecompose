package com.tematihonov.pokedexdecompose.data.repositoryImpl

import com.tematihonov.pokedexdecompose.data.models.PokemonResponse.PokemonResponse
import com.tematihonov.pokedexdecompose.data.models.PokemonsListResponse.PokemonsListResponse
import com.tematihonov.pokedexdecompose.data.network.ApiService
import com.tematihonov.pokedexdecompose.domain.repository.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): NetworkRepository {

    override suspend fun getPokemonsList(limit: Int, offset: Int): PokemonsListResponse {
        return apiService.getPokemonsList(limit,offset)
    }

    override suspend fun getPokemonDetails(name: String): PokemonResponse {
        return apiService.getPokemonDetails(name = name)
    }
}