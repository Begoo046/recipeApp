package com.elifbegum.myapplication.data.repo

import com.elifbegum.myapplication.retrofit.RecipesDao
import com.elifbegum.myapplication.data.entity.RecipeRequest
import com.elifbegum.myapplication.data.entity.Recipes


class RecipesDARepository(var kdao: RecipesDao) {
    suspend fun getRecipes() = kdao.recipes()
    suspend fun foodSearch(searchWord:String) = kdao.foodSearch(searchWord)
    suspend fun recipeDetail(id:Int) = kdao.recipeDetail(id)
    suspend fun addRecipe(request: RecipeRequest) = kdao.addRecipe(request)
    suspend fun recipeUpdate(recipe: Recipes) = kdao.recipeUpdate(recipe)
}