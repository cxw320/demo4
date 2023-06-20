package com.example.demo4.repository

import com.example.demo4.api.SpoonacularApi
import com.example.demo4.api.responsemodel.RecipeDTO
import com.example.demo4.model.Recipe

object RecipeRepository {

    suspend fun getRandomRecipes() : List<Recipe> {
        return SpoonacularApi.apiService.getRandomRecipes().body()?.recipes?.map{
            mapToRecipe(it)
        }?:emptyList()
    }

    fun mapToRecipe(recipeDTO: RecipeDTO) : Recipe {
        return Recipe(
            id = recipeDTO.id,
            title = recipeDTO.title,
            imageUrl = recipeDTO.imageUrl
        )
    }


}