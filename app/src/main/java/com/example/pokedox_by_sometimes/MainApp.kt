package com.example.pokedox_by_sometimes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokedox_by_sometimes.core.designsystem.theme.PokedexTheme
import com.example.pokedox_by_sometimes.navigation.AppNavHost

@Composable
fun MainApp() {
    PokedexTheme {
        AppNavHost()
    }
}