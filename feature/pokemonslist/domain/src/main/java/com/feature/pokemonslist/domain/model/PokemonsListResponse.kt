package com.feature.pokemonslist.domain.model

data class PokemonsListResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)