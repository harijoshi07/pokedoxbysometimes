package com.example.pokedox_by_sometimes.ui

import androidx.compose.runtime.Composable
import com.example.pokedox_by_sometimes.core.designsystem.theme.PokedexTheme
import com.example.pokedox_by_sometimes.navigation.AppNavHost

@Composable
fun MainApp() {
    PokedexTheme {
        AppNavHost()
    }
}