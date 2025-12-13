package com.example.pokedox_by_sometimes.core.designsystem.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.pokedox_by_sometimes.R
import com.example.pokedox_by_sometimes.core.designsystem.theme.PokedexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title),
                color = PokedexTheme.colors.absoluteWhite,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = PokedexTheme.colors.primary
        )
    )
}

@Preview
@Composable
private fun PokedexAppBarPreview() {
    PokedexTheme {
        PokedexAppBar()
    }
}