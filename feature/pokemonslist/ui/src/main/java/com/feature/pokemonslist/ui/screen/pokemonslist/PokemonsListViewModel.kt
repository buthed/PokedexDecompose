package com.feature.pokemonslist.ui.screen.pokemonslist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.utils.Resource
import com.feature.pokemonslist.domain.model.Result
import com.feature.pokemonslist.domain.useccases.LocalUnionUseCase
import com.feature.pokemonslist.domain.useccases.NetworkUnionUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonsListViewModel @Inject constructor(
    private val networkUnionUseCases: NetworkUnionUseCases,
    private val localUnionUseCase: LocalUnionUseCase
) : ViewModel() {

    var pokemonsList: MutableState<Resource<List<Result>>> = mutableStateOf(Resource.Loading())
    var pokemonsArrayList: MutableState<ArrayList<Result>> = mutableStateOf(arrayListOf())

    private var curPage = 0
    var endReached  = mutableStateOf(false)

    init {
        loadPokemonsList()
    }

    fun loadPokemonsList() {
        viewModelScope.launch {
            networkUnionUseCases.getPokemonListUseCase.invoke(20, curPage*20).catch {
                pokemonsList.value = Resource.Error(it.message!!)
            }.collect {
                curPage ++
                endReached.value = curPage * 20 >= it.count
                pokemonsList.value = Resource.Success(it.results)
                pokemonsArrayList.value += it.results.toMutableList()

            }
        }
    }

    fun setNewPokemonNumber(pokemonsUrl: String): String {
        return localUnionUseCase.numberFormatterUseCase.invoke(pokemonsUrl)
    }

    fun setNewPokemonImageUrl(pokemonsUrl: String): String {
        return localUnionUseCase.createPokemonsImageUrlUseCase.invoke(pokemonsUrl)
    }
}