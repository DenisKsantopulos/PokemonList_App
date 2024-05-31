package com.example.pokemonappvk.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pokemonappvk.domain.model.Pokemon
import com.example.pokemonappvk.ui.components.AppLoader
import com.example.pokemonappvk.ui.components.AppTopBar
import com.example.pokemonappvk.ui.components.PokemonItem
import com.example.siburapp.R

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onHomeItemSelected: (String) -> Unit
) {
    val pokemons: LazyPagingItems<Pokemon> =
        homeViewModel.pokemonsListState.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AppTopBar(title = stringResource(id = R.string.app_title))
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {

            if (pokemons.loadState.refresh is LoadState.Loading) {
                AppLoader()
            } else {
                LazyVerticalGrid(columns = GridCells.Fixed(1)) {
                    items(pokemons.itemCount) { pokemonItemIndex ->
                        val pokemon = pokemons[pokemonItemIndex]
                        pokemon?.let { current ->
                            PokemonItem(
                                pokemon = current
                            ) {
                                onHomeItemSelected(pokemon.name)
                            }
                        }
                    }
                }
            }
        }
    }
}