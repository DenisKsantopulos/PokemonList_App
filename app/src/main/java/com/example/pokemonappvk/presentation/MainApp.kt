package com.example.pokemonappvk.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

import com.example.pokemonappvk.presentation.details.navigation.detailsScreen
import com.example.pokemonappvk.presentation.details.navigation.navigateToDetails
import com.example.pokemonappvk.presentation.home.navigation.HOME_ROUTE
import com.example.pokemonappvk.presentation.home.navigation.homeScreen

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = HOME_ROUTE
    ) {
        homeScreen { itemName ->
            navController.navigateToDetails(itemName)
        }
        detailsScreen(onNavigateUp = {
            navController.navigateUp()
        })
    }
}