package com.core.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(com.core.network.utils.RetrofitConstants.POKEMON)
    suspend fun getPokemonsList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): com.core.network.models.PokemonsListResponse.PokemonsListNetwork

    @GET("${com.core.network.utils.RetrofitConstants.POKEMON}{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): com.core.network.models.PokemonResponse.PokemonNetwork
}