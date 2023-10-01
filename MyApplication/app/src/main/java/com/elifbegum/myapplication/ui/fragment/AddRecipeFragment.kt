package com.elifbegum.myapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.elifbegum.myapplication.databinding.FragmentAddRecipeBinding
import com.elifbegum.myapplication.ui.viewmodel.AddRecipeViewModel
import com.elifbegum.myapplication.ui.fragment.AddRecipeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddRecipeFragment : Fragment() {
    private lateinit var binding: FragmentAddRecipeBinding
    private lateinit var viewModel: AddRecipeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddRecipeBinding.inflate(inflater, container, false)

        val tempViewModel: AddRecipeViewModel by viewModels()
        viewModel = tempViewModel

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            val foodName = binding.editTextFoodName.text.toString()
            val recipe = binding.editTextRecipe.text.toString()
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.addRecipes(foodName, recipe)
            }
            viewModel.recipeAdd.observe(viewLifecycleOwner) { recipe ->
                if (recipe != null) {
                    Toast.makeText(requireContext(), "Yemek Tarifi Eklendi", Toast.LENGTH_SHORT)
                        .show()
                    val action =
                        AddRecipeFragmentDirections.actionAddRecipeFragmentToHomePageFragment()
                    Navigation.run { findNavController().navigate(action) }
                } else {
                    Toast.makeText(requireContext(), "Yemek Tarifi Eklenemedi", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}