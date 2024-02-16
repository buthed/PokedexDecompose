package com.tematihonov.pokedexdecompose.domain.usecase

import com.tematihonov.pokedexdecompose.domain.usecase.network.GetPokemonDetailsUseCase
import com.tematihonov.pokedexdecompose.domain.usecase.network.GetPokemonListUseCase

data class NetworkUnionUseCases(
    val getPokemonListUseCase: GetPokemonListUseCase,
    val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
)