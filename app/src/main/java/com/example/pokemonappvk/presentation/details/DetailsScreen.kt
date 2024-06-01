package com.example.pokemonappvk.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.pokemonappvk.presentation.details.intent.DetailsIntent
import com.example.pokemonappvk.ui.components.AppTopBar
import com.example.siburapp.R

@Composable
fun DetailsScreen(
    pokemonName: String,
    detailsViewModel: DetailsViewModel = hiltViewModel(),
    onNavigateUp: () -> Unit
) {
    val state by detailsViewModel.pokemonDetailsState.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) {
        detailsViewModel.processIntent(DetailsIntent.GetDetails(pokemonName))
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            AppTopBar(title = pokemonName, hasBackBtn = true, onBackBtnClicked = onNavigateUp)
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.primary
                        )
                    )
                )
        ) {
            when (state) {
                is DetailsUiState.Exception -> {
                    //TODO: handle errors...
                }

                DetailsUiState.Loading -> {
                    //TODO: handle Loading...
                }

                is DetailsUiState.Success -> {
                    val pokemonDetails = (state as DetailsUiState.Success).data
                    Card(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = MaterialTheme.shapes.medium,
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 0.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            AsyncImage(
                                model = pokemonDetails.imageUrl,
                                contentDescription = null,
                                modifier = Modifier.size(200.dp, 200.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = pokemonDetails.name.capitalize(),
                                fontSize = 24.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = MaterialTheme.shapes.medium,
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 0.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent  //MaterialTheme.colorScheme.surface
                        ),
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Row() {
                                    Text(
                                        text = stringResource(
                                            id = R.string.weight_label
                                        ),
                                        fontWeight = FontWeight.Black,
                                        fontSize = 22.sp,
                                        color = MaterialTheme.colorScheme.onBackground,
                                        modifier = Modifier.padding(end = 5.dp)
                                    )
                                    Text(
                                        text = stringResource(
                                            id = R.string.weight_value,
                                            pokemonDetails.weightKg,
                                        ),
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 22.sp,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                                Row {
                                    Text(
                                        text = stringResource(
                                            id = R.string.height_label
                                        ),
                                        fontWeight = FontWeight.Black,
                                        modifier = Modifier.padding(end = 5.dp),
                                        fontSize = 22.sp,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                    Text(
                                        text = stringResource(
                                            id = R.string.height_value,
                                            pokemonDetails.heightM,
                                        ),
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 22.sp,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                            }
                        }

                    }
                }

                else -> {}
            }
        }
    }
}