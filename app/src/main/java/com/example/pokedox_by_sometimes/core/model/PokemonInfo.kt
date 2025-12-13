package com.example.pokedox_by_sometimes.core.model

import kotlin.random.Random

data class PokemonInfo(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val types: List<TypeResponse>,
    val stats: List<StatsResponse>,
    val exp: Int = Random.nextInt(MAX_EXP)
) {
    data class TypeResponse(
        val slot: Int,
        val type: Type
    )

    data class StatsResponse(
        val baseStat: Int,
        val effort: Int,
        val stat: Stat
    )

    data class Stat(
        val name: String
    )

    data class Type(
        val name: String
    )

    companion object {
        const val MAX_HP = 300
        const val MAX_ATTACK = 300
        const val MAX_DEFENSE = 300
        const val MAX_SPEED = 300
        const val MAX_EXP = 1000
    }
}

