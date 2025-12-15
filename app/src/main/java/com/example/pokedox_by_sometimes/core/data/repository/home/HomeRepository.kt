package com.example.pokedox_by_sometimes.core.data.repository.home

import androidx.annotation.WorkerThread
import com.example.pokedox_by_sometimes.core.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    @WorkerThread
    fun fetchPokemonList(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onLastPageReached: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<Pokemon>>

}