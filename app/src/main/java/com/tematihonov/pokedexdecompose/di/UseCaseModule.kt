package com.tematihonov.pokedexdecompose.di

import com.tematihonov.pokedexdecompose.data.repositoryImpl.NetworkRepositoryImpl
import com.tematihonov.pokedexdecompose.domain.repository.NetworkRepository
import com.tematihonov.pokedexdecompose.domain.usecase.NetworkUnionUseCases
import com.tematihonov.pokedexdecompose.domain.usecase.network.GetPokemonDetailsUseCase
import com.tematihonov.pokedexdecompose.domain.usecase.network.GetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideNetworkRepositoryImpl(repository: NetworkRepositoryImpl): NetworkRepository {
        return repository
    }

    @Singleton
    @Provides
    fun provideNetworkUnionUseCases(networkRepository: NetworkRepository): NetworkUnionUseCases {
        return NetworkUnionUseCases(
            getPokemonDetailsUseCase = GetPokemonDetailsUseCase(networkRepository),
            getPokemonListUseCase = GetPokemonListUseCase(networkRepository),
        )
    }
}