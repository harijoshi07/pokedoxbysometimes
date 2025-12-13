package com.example.pokedox_by_sometimes.feature.details

import androidx.annotation.FloatRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.pokedox_by_sometimes.core.designsystem.theme.PokedexTheme
import com.example.pokedox_by_sometimes.core.model.PokemonInfo
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import com.example.pokedox_by_sometimes.R

data class PokedexStatus(
    val type: String,
    @FloatRange(0.0, 1.0) val progress: Float,
    val color: Color,
    val label: String
)

@Composable
internal fun PokemonInfo.toPokedexStatusList(): ImmutableList<PokedexStatus> {
    return persistentListOf(
        PokedexStatus(
            type = "HP",
            progress = hp / PokemonInfo.MAX_HP.toFloat(),
            color = PokedexTheme.colors.primary,
            label = getHpString(),
        ),
        PokedexStatus(
            type = "ATK",
            progress = attack / PokemonInfo.MAX_ATTACK.toFloat(),
            color = PokedexTheme.colors.orange,
            label = getAttackString(),
        ),
        PokedexStatus(
            type = "DEF",
            progress = defense / PokemonInfo.MAX_DEFENSE.toFloat(),
            color = PokedexTheme.colors.blue,
            label = getDefenseString(),
        ),
        PokedexStatus(
            type = "SPD",
            progress = speed / PokemonInfo.MAX_SPEED.toFloat(),
            color = PokedexTheme.colors.flying,
            label = getSpeedString(),
        ),
        PokedexStatus(
            type = "EXP",
            progress = exp / PokemonInfo.MAX_EXP.toFloat(),
            color = PokedexTheme.colors.green,
            label = getExpString(),
        ),
    )
}