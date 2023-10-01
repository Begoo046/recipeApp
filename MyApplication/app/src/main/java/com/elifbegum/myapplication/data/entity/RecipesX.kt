package com.elifbegum.myapplication.data.entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RecipesX(
    @SerializedName("recipes")
    var recipes: List<Recipes>,
    @SerializedName("status")
    var status: Int
) : Serializable