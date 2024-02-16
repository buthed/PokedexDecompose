package com.tematihonov.pokedexdecompose.domain.usecase.network

import com.tematihonov.pokedexdecompose.data.models.PokemonsListResponse.PokemonsListResponse
import com.tematihonov.pokedexdecompose.domain.repository.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val networkRepository: NetworkRepository
) {
    suspend operator fun invoke(): Flow<PokemonsListResponse> = flow {
        emit(networkRepository.getPokemonsList())
    }.flowOn(Dispatchers.IO)
}