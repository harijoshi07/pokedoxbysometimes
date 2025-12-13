package com.example.pokedox_by_sometimes.feature.details

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedox_by_sometimes.core.designsystem.theme.PokedexTheme
import com.example.pokedox_by_sometimes.core.designsystem.utils.getPokemonTypeColor
import com.example.pokedox_by_sometimes.core.model.Pokemon
import com.example.pokedox_by_sometimes.core.model.PokemonInfo
import com.example.pokedox_by_sometimes.core.preview.PreviewUtils

@Composable
fun DetailsScreen(
    pokemon: Pokemon,
    pokemonInfo: PokemonInfo
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PokedexTheme.colors.background)
            .verticalScroll(rememberScrollState())
            .testTag("PokedexDetails")
    ) {
        DetailsHeader(pokemon)
        DetailsInfo(pokemonInfo = pokemonInfo)
        DetailsStatus(pokemonInfo = pokemonInfo)
    }

}

@Composable
fun DetailsHeader(pokemon: Pokemon) {
    val shape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomStart = 64.dp,
        bottomEnd = 64.dp,
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)
            .shadow(elevation = 9.dp, shape = shape)
            .background(color = PokedexTheme.colors.background)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier.padding(end = 6.dp),
            tint = PokedexTheme.colors.absoluteWhite,
        )
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = pokemon.nameField,
            color = PokedexTheme.colors.absoluteWhite,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        )
    }
    
}

@Composable
private fun DetailsInfo(pokemonInfo: PokemonInfo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(22.dp, Alignment.CenterHorizontally),
    ) {
        pokemonInfo.types.forEach { typeInfo ->
            Text(
                modifier = Modifier
                    .background(
                        color = getPokemonTypeColor(type = typeInfo.type.name),
                        shape = RoundedCornerShape(64.dp),
                    )
                    .padding(horizontal = 40.dp, vertical = 4.dp),
                text = typeInfo.type.name,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = PokedexTheme.colors.absoluteWhite,
                maxLines = 1,
                fontSize = 16.sp,
            )
        }
    }
}

@Composable
fun DetailsStatus(pokemonInfo: PokemonInfo) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 22.dp, bottom = 16.dp),
        text = "Base Stats",
        textAlign = TextAlign.Center,
        color = PokedexTheme.colors.black,
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
    )

    Column {
        pokemonInfo.toPokedexStatusList().forEach { pokedexStatus ->
            PokemonStatusItem(
                modifier = Modifier.padding(bottom = 12.dp),
                pokedexStatus = pokedexStatus
            )
        }
    }
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DetailsScreenPreview() {
    PokedexTheme {
        DetailsScreen(
            pokemon = PreviewUtils.mockPokemon(),
            pokemonInfo = PreviewUtils.mockPokemonInfo()
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DetailsInfoPreview() {
    PokedexTheme {
        DetailsInfo(pokemonInfo = PreviewUtils.mockPokemonInfo())
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DetailsStatusPreview() {
    PokedexTheme {
        DetailsStatus(
            pokemonInfo = PreviewUtils.mockPokemonInfo(),
        )
    }
}