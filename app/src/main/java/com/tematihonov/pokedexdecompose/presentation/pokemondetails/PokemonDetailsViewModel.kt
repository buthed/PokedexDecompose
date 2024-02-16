package com.tematihonov.pokedexdecompose.presentation.pokemondetails

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematihonov.pokedexdecompose.data.models.PokemonResponse.PokemonResponse
import com.tematihonov.pokedexdecompose.domain.usecase.NetworkUnionUseCases
import com.tematihonov.pokedexdecompose.utils.Resource
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
                pokemon.value = Resource.Loading()
            }.catch {
                pokemon.value = Resource.Error(it.message!!)
            }.collect {
                pokemon.value = Resource.Success(it)
                Log.d("GGG", "pokemon ${it}")
            }
        }
    }
}