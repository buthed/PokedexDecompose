package com.feature.pokemon_details.data.di

import com.core.network.dataproviders.PokedexDataProvider
import com.feature.pokemon_details.domain.repo.PokemonDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun providePokemonDetailsRepo(pokedexDataProvider: PokedexDataProvider): PokemonDetailsRepository {
        return PokemonDetailsRepositoryImpl(pokedexDataProvider)
    }
}