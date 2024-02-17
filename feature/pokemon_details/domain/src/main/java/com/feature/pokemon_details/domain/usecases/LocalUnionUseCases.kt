package com.feature.pokemon_details.domain.usecases

import com.feature.pokemon_details.domain.usecases.local.CreatePokemonsImageUrlUseCase
import com.feature.pokemon_details.domain.usecases.local.NumberFormatterUseCase

data class LocalUnionUseCases(
    val createPokemonsImageUrlUseCase: CreatePokemonsImageUrlUseCase,
    val numberFormatterUseCase: NumberFormatterUseCase
)