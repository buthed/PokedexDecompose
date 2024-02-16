package com.tematihonov.pokedexdecompose.data.network

import com.tematihonov.pokedexdecompose.data.models.PokemonResponse.PokemonResponse
import com.tematihonov.pokedexdecompose.data.models.PokemonsListResponse.PokemonsListResponse
import com.tematihonov.pokedexdecompose.utils.RetrofitConstants
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(RetrofitConstants.POKEMON)
    suspend fun getPokemonsList(): PokemonsListResponse

    @GET("${RetrofitConstants.POKEMON}{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): PokemonResponse
}