package com.feature.pokemonslist.domain.model

data class PokemonsListResponse(
    val count: Int = 1000,
    val next: String = "https://pokeapi.co/api/v2/pokemon/?offset=20&limit=20",
    val previous: Any? = null,
    val results: List<Result> = emptyList()
)