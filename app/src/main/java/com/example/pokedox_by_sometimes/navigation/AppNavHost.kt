package com.example.pokedox_by_sometimes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.pokedox_by_sometimes.core.preview.PreviewUtils.mockPokemonInfo
import com.example.pokedox_by_sometimes.feature.details.DetailsScreen
import com.example.pokedox_by_sometimes.feature.home.HomeScreen

@Composable
fun AppNavHost() {
    val backStack = rememberNavBackStack(PokedexScreen.Home)
    val navigator = remember(backStack) { PokedexNavigatorImpl(backStack) }

    CompositionLocalProvider(
        LocalComposeNavigator provides navigator,
    ) {
        NavDisplay(
            backStack = backStack,
            onBack = {backStack.removeLastOrNull()},
            entryDecorators = listOf(rememberSaveableStateHolderNavEntryDecorator()),
            entryProvider = entryProvider {
                entry<PokedexScreen.Home> {
                    HomeScreen()
                }

                entry<PokedexScreen.Details> {
                    DetailsScreen(it.pokemon, mockPokemonInfo())
                }
            }
        )
    }
}