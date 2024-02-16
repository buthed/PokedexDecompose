package com.core.network.dataproviders

import com.core.network.ApiService
import com.core.network.models.PokemonResponse.PokemonNetwork
import com.core.network.models.PokemonsListResponse.PokemonsListNetwork
import javax.inject.Inject

class PokedexDataProvider @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getPokemonsList(limit: Int, offset: Int): PokemonsListNetwork { //TODO add dto to models
        return apiService.getPokemonsList(limit = limit, offset = offset)
    }

    suspend fun getPokemonDetails(name: String): PokemonNetwork {
        return apiService.getPokemonDetails(name)
    }

}