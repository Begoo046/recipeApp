package com.elifbegum.myapplication.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.elifbegum.myapplication.data.entity.Recipes
import com.elifbegum.myapplication.databinding.HomeCardBinding
import com.elifbegum.myapplication.ui.fragment.HomePageFragmentDirections
import com.elifbegum.myapplication.ui.viewmodel.HomePageViewModel
import com.elifbegum.myapplication.util.toggle

class RecipesAdapter(
    var recipesList: List<Recipes>,
    var view: HomePageViewModel
) : RecyclerView.Adapter<RecipesAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(val binding: HomeCardBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val view = HomeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardDesignHolder(view)
    }
    override fun getItemCount(): Int {
        return recipesList.size
    }
    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val repices = recipesList[position]
        holder.binding.textViewName.text = repices.name
        holder.binding.goToDetail.setOnClickListener {
            Log.e("Recipe Adapter", "satırCard tıklandı")
            val passing = HomePageFragmentDirections.actionHomePageFragmentToDetailFragment(recipeId = repices.id)
            Navigation.toggle(it, passing)
        }
    }
}