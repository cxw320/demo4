package com.example.demo4.features.recipediscovery

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo4.model.Recipe
import com.example.demo4.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeDiscoveryViewModel : ViewModel() {


    //-------Section 1 : class variables to expose state / data that our composables need access to
    //private variable that we'll update with our methods
    private val _recipeDiscoveryUiState = MutableStateFlow(RecipeDiscoveryUiState())

    //public variable that we'll expose to our screen composable
    val recipeDiscoveryUiState : StateFlow<RecipeDiscoveryUiState> = _recipeDiscoveryUiState.asStateFlow()



    //-------Section 2 : methods to update that state

    init{
        viewModelScope.launch{
            getRandomRecipes()
        }
    }


    public fun getRandomRecipes() {
        viewModelScope.launch{
            _recipeDiscoveryUiState.value =
                _recipeDiscoveryUiState.value.copy(
                    recipeList = RecipeRepository.getRandomRecipes()
                )
        }

    }

}