package com.feature.pokemon_details.ui.screen.pokemondetails

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.utils.Resource
import com.feature.pokemon_details.domain.model.PokemonResponse.PokemonResponse
import com.feature.pokemon_details.domain.usecases.NetworkUnionUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val networkUnionUseCases: NetworkUnionUseCases
): ViewModel() {

    val pokemon: MutableState<Resource<PokemonResponse>> = mutableStateOf(Resource.Loading())

    fun loadPokemonInfo(pokemonsName: String) {
        viewModelScope.launch {
            networkUnionUseCases.getPokemonDetailsUseCase.invoke(pokemonsName).onStart {
                pokemon.value = com.core.common.utils.Resource.Loading()
            }.catch {
                pokemon.value = com.core.common.utils.Resource.Error(it.message!!)
            }.collect {
                pokemon.value = com.core.common.utils.Resource.Success(it)
                Log.d("GGG", "pokemon ${it}")
            }
        }
    }
}