package com.elifbegum.myapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elifbegum.myapplication.data.entity.BaseRecipes
import com.elifbegum.myapplication.data.entity.RecipesAnswer
import com.elifbegum.myapplication.data.entity.RecipesX
import com.elifbegum.myapplication.data.repo.RecipesDARepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
@HiltViewModel
class HomePageViewModel @Inject constructor(val krepo: RecipesDARepository) : ViewModel() {

    var recipesList = MutableLiveData<RecipesAnswer>()
    var recipeSearch = MutableLiveData<RecipesX>()
    fun getRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = krepo.getRecipes()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    recipesList.value = response.body()
                } else {
                }
            }
        }
    }
    fun foodSearch(searchWord: String) {
        viewModelScope.launch {
            val response = krepo.foodSearch(searchWord)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    recipeSearch.value = response.body()
                } else {
                }
            }
        }
    }
}