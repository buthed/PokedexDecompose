package com.tematihonov.pokedexdecompose.data.network

import com.tematihonov.pokedexdecompose.data.models.PokemonResponse.PokemonResponse
import com.tematihonov.pokedexdecompose.data.models.PokemonsListResponse.PokemonsListResponse
import com.tematihonov.pokedexdecompose.utils.RetrofitConstants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(RetrofitConstants.POKEMON)
    suspend fun getPokemonsList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonsListResponse

    @GET("${RetrofitConstants.POKEMON}{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): PokemonResponse
}