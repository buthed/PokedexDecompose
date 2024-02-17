package com.feature.pokemonslist.domain.di

import com.feature.pokemonslist.domain.repo.PokedexRepository
import com.feature.pokemonslist.domain.useccases.LocalUnionUseCase
import com.feature.pokemonslist.domain.useccases.NetworkUnionUseCases
import com.feature.pokemonslist.domain.useccases.local.CreatePokemonsImageUrlUseCase
import com.feature.pokemonslist.domain.useccases.local.NumberFormatterUseCase
import com.feature.pokemonslist.domain.useccases.network.GetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideNetworkUnionUseCases(pokedexRepository: PokedexRepository): NetworkUnionUseCases {
        return NetworkUnionUseCases(
            getPokemonListUseCase = GetPokemonListUseCase(pokedexRepository),
        )
    }

    @Provides
    fun provideLocalUnionUseCases(): LocalUnionUseCase {
        return LocalUnionUseCase(
            createPokemonsImageUrlUseCase = CreatePokemonsImageUrlUseCase(),
            numberFormatterUseCase = NumberFormatterUseCase()
        )
    }
}