package com.feature.pokemonslist.domain.useccases

import com.feature.pokemonslist.domain.useccases.local.CreatePokemonsImageUrlUseCase
import com.feature.pokemonslist.domain.useccases.local.NumberFormatterUseCase

data class LocalUnionUseCase(
    val createPokemonsImageUrlUseCase: CreatePokemonsImageUrlUseCase,
    val numberFormatterUseCase: NumberFormatterUseCase
)