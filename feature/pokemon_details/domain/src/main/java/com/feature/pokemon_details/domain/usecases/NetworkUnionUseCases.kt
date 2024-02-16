package com.feature.pokemon_details.domain.usecases

import com.feature.pokemon_details.domain.usecases.network.GetPokemonDetailsUseCase

data class NetworkUnionUseCases(
    val getPokemonDetailsUseCase: GetPokemonDetailsUseCase,
)
