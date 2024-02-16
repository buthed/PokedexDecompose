package com.feature.pokemonslist.data.mapper

import com.core.network.models.PokemonResponse.PokemonNetwork
import com.core.network.models.PokemonsListResponse.PokemonsListNetwork
import com.feature.pokemonslist.domain.model.Result

fun PokemonsListNetwork.toDomainPokemonList(): List<Result> {
    return this.results.map { Result(it.name,it.url) }
}