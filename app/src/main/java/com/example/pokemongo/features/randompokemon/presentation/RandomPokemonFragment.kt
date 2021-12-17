package com.example.pokemongo.features.randompokemon.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokemongo.R
import com.example.pokemongo.appComponent
import com.example.pokemongo.databinding.FragmentRandomPokemonBinding
import com.example.pokemongo.factory.ViewModelFactory
import com.example.pokemongo.features.randompokemon.di.DaggerRandomPokemonComponent
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class RandomPokemonFragment: Fragment(R.layout.fragment_random_pokemon) {

    private val viewBinding: FragmentRandomPokemonBinding by viewBinding(FragmentRandomPokemonBinding::bind)
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: RandomPokemonViewModel by viewModels(
        factoryProducer = { viewModelFactory }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerRandomPokemonComponent.builder()
            .retrofit(appComponent.retrofit)
            .context(appComponent.context)
            .build()
            .inject(this)

        initViews()
        observe()
    }

    @SuppressLint("SetTextI18n")
    private fun observe() {
        val random = (0..899).random()
        viewModel.getPokemon(random.toString())
        viewModel.btnVisible.observe(viewLifecycleOwner){
            viewBinding.btnFavorite.isVisible = it
            viewBinding.btnRandomPokemon.isVisible = it
        }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            viewBinding.cpiLoading.isVisible = it
        }
        viewModel.pokemon.observe(viewLifecycleOwner) {
            viewBinding.tvName.text = getString(R.string.name) + " ${it.name}"
            viewBinding.tvBaseExperience.text =
                getString(R.string.base_experience) + " ${it.baseExperience}"
            viewBinding.tvHeight.text = getString(R.string.height) + " ${it.height}"
            viewBinding.tvWeight.text = getString(R.string.weight) + " ${it.weight}"
        }
        viewModel.showErrorEvent.observe(viewLifecycleOwner) {
            Toast.makeText(
                requireContext(),
                getString(R.string.pokemon_not_found),
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    private fun initViews() {
        viewBinding.btnFavorite.setOnClickListener {
            viewModel.onAddFavoritePokemonClick()
            val snackbar =
                Snackbar.make(requireView(), getString(R.string.marked_as_favourite), 3000)
            snackbar.anchorView = null
            snackbar.show()
        }

        viewBinding.btnRandomPokemon.setOnClickListener {
            val random = (0..899).random()
            viewModel.getPokemon(random.toString())
        }
    }
}
