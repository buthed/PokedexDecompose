package com.tematihonov.pokedexdecompose.data.models.PokemonsListResponse

data class PokemonsListResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)