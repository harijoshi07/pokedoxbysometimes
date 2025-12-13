package com.example.pokedox_by_sometimes.feature.home

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedox_by_sometimes.R
import com.example.pokedox_by_sometimes.core.designsystem.component.PokedexAppBar
import com.example.pokedox_by_sometimes.core.designsystem.theme.PokedexTheme
import com.example.pokedox_by_sometimes.core.model.Pokemon
import com.example.pokedox_by_sometimes.core.preview.PreviewUtils
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PokedexAppBar()
    }
}

@Composable
fun HomeContent(
    pokemonList: List<Pokemon>,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val threadHold = 8
        LazyVerticalGrid(
            modifier = Modifier.testTag("PokedexList"),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(6.dp)
        ) {
            itemsIndexed(pokemonList) { index, pokemon ->
                PokemonCard(
                    pokemon = pokemon
                )
            }
        }
    }
}


@Composable
fun PokemonCard(pokemon: Pokemon) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .testTag("Pokemon")
            .clickable { },
        shape = RoundedCornerShape(14.dp),
        colors = CardColors(
            containerColor = PokedexTheme.colors.background,
            contentColor = PokedexTheme.colors.background,
            disabledContainerColor = PokedexTheme.colors.background,
            disabledContentColor = PokedexTheme.colors.background
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        GlideImage(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp)
                .size(120.dp),
            imageModel = { pokemon.url },
            imageOptions = ImageOptions(contentScale = ContentScale.Inside),
            previewPlaceholder = painterResource(id = R.drawable.pokemon_preview)
        )


        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(12.dp),
            text = pokemon.nameField,
            color = PokedexTheme.colors.black,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewHomeContent() {
    PokedexTheme {
        HomeContent(
            pokemonList = PreviewUtils.mockPokemonList()
        )
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