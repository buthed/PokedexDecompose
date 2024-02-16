package com.feature.pokemonslist.domain.useccases

import com.feature.pokemonslist.domain.useccases.network.GetPokemonListUseCase

data class NetworkUnionUseCases(
    val getPokemonListUseCase: GetPokemonListUseCase,
)
