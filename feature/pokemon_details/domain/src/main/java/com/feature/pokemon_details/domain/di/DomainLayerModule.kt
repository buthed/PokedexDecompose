package com.feature.pokemon_details.domain.di

import com.feature.pokemon_details.domain.repo.PokemonDetailsRepository
import com.feature.pokemon_details.domain.usecases.NetworkUnionUseCases
import com.feature.pokemon_details.domain.usecases.network.GetPokemonDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideNetworkUnionUseCases(pokemonDetailsRepository: PokemonDetailsRepository): NetworkUnionUseCases {
        return NetworkUnionUseCases(
            getPokemonDetailsUseCase = GetPokemonDetailsUseCase(pokemonDetailsRepository),
        )
    }
}