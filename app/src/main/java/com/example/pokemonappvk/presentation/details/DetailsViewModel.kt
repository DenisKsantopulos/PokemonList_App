package com.example.pokemonappvk.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.usecase.detail.GetPokemonDetails
import com.example.pokemonapp.domain.usecase.detail.PokemonDetailsRequestState
import com.example.pokemonappvk.presentation.details.intent.DetailsIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getPokemonDetails: com.example.pokemonapp.domain.usecase.detail.GetPokemonDetails
) : ViewModel() {

    private val _pokemonDetailsState: MutableStateFlow<DetailsUiState> =
        MutableStateFlow(DetailsUiState.Idle)
    val pokemonDetailsState: StateFlow<DetailsUiState> = _pokemonDetailsState.asStateFlow()

    fun processIntent(detailsIntent: DetailsIntent) {
        if (detailsIntent is DetailsIntent.GetDetails) {
            getPokemonDetails(detailsIntent.name)
        }
    }

    private fun getPokemonDetails(name: String) {
        viewModelScope.launch {
            getPokemonDetails.invoke(name).collect { detailsRequestState ->
                _pokemonDetailsState.value = when (detailsRequestState) {
                    is com.example.pokemonapp.domain.usecase.detail.PokemonDetailsRequestState.Exception -> DetailsUiState.Exception(
                        code = detailsRequestState.code,
                        exception = detailsRequestState.exception
                    )

                    is com.example.pokemonapp.domain.usecase.detail.PokemonDetailsRequestState.Success -> DetailsUiState.Success(
                        data = detailsRequestState.data
                    )

                    com.example.pokemonapp.domain.usecase.detail.PokemonDetailsRequestState.Loading -> DetailsUiState.Loading
                }
            }
        }
    }
}