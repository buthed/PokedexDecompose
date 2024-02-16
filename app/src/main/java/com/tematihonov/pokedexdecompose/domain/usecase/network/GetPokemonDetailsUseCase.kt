package com.tematihonov.pokedexdecompose.domain.usecase.network

import com.tematihonov.pokedexdecompose.data.models.PokemonResponse.PokemonResponse
import com.tematihonov.pokedexdecompose.domain.repository.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(
    private val networkRepository: NetworkRepository
) {
    suspend operator fun invoke(name: String): Flow<PokemonResponse> = flow {
        emit(networkRepository.getPokemonDetails(name))
    }.flowOn(Dispatchers.IO)
}