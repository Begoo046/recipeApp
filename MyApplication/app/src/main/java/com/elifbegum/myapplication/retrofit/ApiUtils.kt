package com.elifbegum.myapplication.retrofit

class ApiUtils {
    companion object {
        const val BASE_URL = "https://api.canerture.com/recipes/"
        fun getRecipesDao(): RecipesDao {
            return RetrofitClient.getClient(BASE_URL).create(RecipesDao::class.java)
        }
    }
}