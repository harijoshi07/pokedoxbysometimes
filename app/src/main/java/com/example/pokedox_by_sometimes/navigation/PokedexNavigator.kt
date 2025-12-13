package com.example.pokedox_by_sometimes.navigation

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

interface PokedexNavigator {
    /**
     * Navigate to a new screen by adding it to the back stack.
     */
    fun navigate(screen: PokedexScreen)

    /**
     * Navigate back by removing the top screen from the back stack.
     * @return true if navigation was successful, false if back stack is empty or only has one item.
     */
    fun navigateUp(): Boolean
}

/**
 * Implementation of [PokedexNavigator] that operates on a [NavBackStack].
 */
class PokedexNavigatorImpl(
    private val backStack: NavBackStack<NavKey>,
) : PokedexNavigator {

    override fun navigate(screen: PokedexScreen) {
        backStack.add(screen)
    }

    override fun navigateUp(): Boolean {
        return if (backStack.size > 1) {
            backStack.removeLastOrNull() != null
        } else {
            false
        }
    }
}