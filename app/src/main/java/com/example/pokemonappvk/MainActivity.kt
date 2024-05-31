package com.example.pokemonappvk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pokemonappvk.presentation.MainApp
import com.example.pokemonappvk.ui.theme.PokemonAppVKTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonAppVKTheme {
                MainApp()
            }
        }
    }
}