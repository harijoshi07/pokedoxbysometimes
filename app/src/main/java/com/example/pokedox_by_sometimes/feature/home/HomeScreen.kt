package com.example.pokedox_by_sometimes.feature.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokedox_by_sometimes.core.designsystem.component.PokedexAppBar
import com.example.pokedox_by_sometimes.core.designsystem.theme.PokedexTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PokedexAppBar()
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewHomeScreen() {
    PokedexTheme {
        HomeScreen()
    }

}