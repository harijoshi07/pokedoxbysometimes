package com.example.pokedox_by_sometimes.core.data.repository.home

import androidx.annotation.WorkerThread
import com.example.pokedox_by_sometimes.core.model.Pokemon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val pokedexClient: PokedexClient,
    private val pokemonDao: PokemonDao,
    private val ioDispatcher: CoroutineDispatcher
): HomeRepository {

    @WorkerThread
    override fun fetchPokemonList(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onLastPageReached: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<Pokemon>> {
        TODO("Not yet implemented")
    }
}