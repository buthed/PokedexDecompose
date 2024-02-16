package com.feature.pokemon_details.data.repo

import com.core.network.dataproviders.PokedexDataProvider
import com.feature.pokemon_details.data.mapper.toDomainPokemon
import com.feature.pokemon_details.domain.model.PokemonResponse.PokemonResponse
import com.feature.pokemon_details.domain.repo.PokemonDetailsRepository
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(
    private val pokedexDataProvider: PokedexDataProvider
): PokemonDetailsRepository {

    override suspend fun getPokemonDetails(name: String): PokemonResponse {
        return pokedexDataProvider.getPokemonDetails(name).toDomainPokemon()
    }

}