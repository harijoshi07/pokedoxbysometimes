package com.example.pokedox_by_sometimes.core.network.service

import retrofit2.http.GET
import retrofit2.http.Query


interface PokedexService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): ApiResponse<PokemonResponse>
}