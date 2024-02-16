package com.feature.pokemon_details.domain.usecases.network

import com.feature.pokemon_details.domain.model.PokemonResponse.PokemonResponse
import com.feature.pokemon_details.domain.repo.PokemonDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(
    private val pokemonDetailsRepository: PokemonDetailsRepository
) {
    suspend operator fun invoke(name: String): Flow<PokemonResponse> = flow {
        emit(pokemonDetailsRepository.getPokemonDetails(name))
    }.flowOn(Dispatchers.IO)
}