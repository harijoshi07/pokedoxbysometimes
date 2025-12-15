package com.example.pokedox_by_sometimes.core.data.repository.home

import com.example.pokedox_by_sometimes.core.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeHomeRepository {
    override fun fetchPokemonList(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onLastPageReached: () -> Unit,
        onError: (String?) -> Unit,
    ): Flow<List<Pokemon>> = flowOf()
}