package com.example.pokedox_by_sometimes.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    var page: Int = 0,
    val nameField: String,
    val url: String,
)