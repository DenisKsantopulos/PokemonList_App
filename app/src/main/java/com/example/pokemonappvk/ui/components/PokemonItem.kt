package com.example.pokemonappvk.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokemonappvk.domain.model.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonItem(
    pokemon: Pokemon,
    onPokemonItemClicked: (Pokemon) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        onClick = {
            onPokemonItemClicked.invoke(pokemon)
        }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start

        ) {
            AsyncImage(model = pokemon.imageUrl, contentDescription = null,
                modifier = Modifier.size(100.dp, 100.dp))
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                modifier = Modifier.padding(top = 40.dp, bottom = 8.dp),
                text = pokemon.name.capitalize(),
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

    }
}


@Preview
@Composable
fun PreviewPokemonItem() {
    PokemonItem(
        pokemon = Pokemon(
            name = "ivysaur",
            url = "https://pokeapi.co/api/v2/pokemon/2/"
        )
    ) {
    }
}