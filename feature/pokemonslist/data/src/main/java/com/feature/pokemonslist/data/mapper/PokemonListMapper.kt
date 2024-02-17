package com.feature.pokemonslist.data.mapper

import com.core.network.models.PokemonsListResponse.PokemonsListNetwork
import com.feature.pokemonslist.domain.model.PokemonsListResponse
import com.feature.pokemonslist.domain.model.Result

//fun PokemonsListNetwork.toDomainPokemonList(): List<Result> {
//    return this.results.map { Result(it.name,it.url) }
//}

fun PokemonsListNetwork.toDomainPokemonList(): PokemonsListResponse {

    return PokemonsListResponse(
        count = this.count,
        next = this.next,
        previous = this.previous,
        results =this.results.map { Result(it.name,it.url) }
    )
}