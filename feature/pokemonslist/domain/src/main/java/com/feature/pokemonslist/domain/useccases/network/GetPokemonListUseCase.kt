package com.feature.pokemonslist.domain.useccases.network

import com.feature.pokemonslist.domain.model.PokemonsListResponse
import com.feature.pokemonslist.domain.model.Result
import com.feature.pokemonslist.domain.repo.PokedexRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokedexRepository: PokedexRepository
) {
    suspend operator fun invoke(limit: Int, offset: Int): Flow<PokemonsListResponse> = flow {
        emit(pokedexRepository.getPokemonsList(limit = limit, offset = offset))
    }.flowOn(Dispatchers.IO)
}