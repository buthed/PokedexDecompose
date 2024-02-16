package com.feature.pokemon_details.domain.repo

import com.feature.pokemon_details.domain.model.PokemonResponse.PokemonResponse

interface PokemonDetailsRepository {

    suspend fun getPokemonDetails(name: String): PokemonResponse

}