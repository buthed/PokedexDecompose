package com.tematihonov.pokedexdecompose.presentation.pokemonslist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematihonov.pokedexdecompose.data.models.PokemonsListResponse.Result
import com.tematihonov.pokedexdecompose.domain.usecase.NetworkUnionUseCases
import com.tematihonov.pokedexdecompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonsListViewModel @Inject constructor(
    private val networkUnionUseCases: NetworkUnionUseCases,
) : ViewModel() {

    var pokemonsList: MutableState<Resource<List<Result>>> = mutableStateOf(Resource.Loading())

    init {
        loadPokemonsList()
    }

    fun loadPokemonsList() {
        viewModelScope.launch {
            networkUnionUseCases.getPokemonListUseCase.invoke().onStart {
                pokemonsList.value = Resource.Loading()
            }.catch {
                pokemonsList.value = Resource.Error(it.message!!)
            }.collect {
                pokemonsList.value = Resource.Success(it.results)
            }
        }
    }
}