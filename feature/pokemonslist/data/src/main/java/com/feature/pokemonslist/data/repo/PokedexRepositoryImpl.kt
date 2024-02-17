package com.feature.pokemonslist.data.repo

import com.core.network.dataproviders.PokedexDataProvider
import com.feature.pokemonslist.data.mapper.toDomainPokemonList
import com.feature.pokemonslist.domain.model.PokemonsListResponse
import com.feature.pokemonslist.domain.model.Result
import com.feature.pokemonslist.domain.repo.PokedexRepository
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor(
    private val pokedexDataProvider: PokedexDataProvider
): PokedexRepository {

    override suspend fun getPokemonsList(limit: Int, offset: Int): PokemonsListResponse {
        return pokedexDataProvider.getPokemonsList(limit = limit, offset = offset).toDomainPokemonList()
    }
}