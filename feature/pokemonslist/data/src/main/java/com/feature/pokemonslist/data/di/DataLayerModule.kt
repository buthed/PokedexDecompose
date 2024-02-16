package com.feature.pokemonslist.data.di

import com.core.network.dataproviders.PokedexDataProvider
import com.feature.pokemonslist.data.repo.PokedexRepositoryImpl
import com.feature.pokemonslist.domain.repo.PokedexRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun providePokedexRepository(pokedexDataProvider: PokedexDataProvider): PokedexRepository {
        return PokedexRepositoryImpl(pokedexDataProvider)
    }
}