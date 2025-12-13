package com.example.pokedox_by_sometimes.navigation

import androidx.navigation3.runtime.NavKey
import com.example.pokedox_by_sometimes.core.model.Pokemon
import kotlinx.serialization.Serializable

sealed interface PokedexScreen : NavKey {

    @Serializable
    data object Home : PokedexScreen

    @Serializable
    data class Details(val pokemon: Pokemon) : PokedexScreen
}