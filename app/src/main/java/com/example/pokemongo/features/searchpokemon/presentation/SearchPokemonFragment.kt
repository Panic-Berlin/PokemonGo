package com.example.pokemongo.features.searchpokemon.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokemongo.R
import com.example.pokemongo.appComponent
import com.example.pokemongo.databinding.FragmentSearchPokemonBinding
import com.example.pokemongo.factory.ViewModelFactory
import com.example.pokemongo.features.searchpokemon.di.DaggerPokemonSearchComponent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchPokemonFragment : Fragment(R.layout.fragment_search_pokemon) {

    private val viewBinding: FragmentSearchPokemonBinding by viewBinding(
        FragmentSearchPokemonBinding::bind
    )

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: SearchPokemonViewModel by viewModels(
        factoryProducer = { viewModelFactory }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        DaggerPokemonSearchComponent.builder()
            .retrofit(appComponent.retrofit)
            .build()
            .inject(this)

        super.onViewCreated(view, savedInstanceState)

        initViews()
        observe()
    }

    private fun initViews() {
        viewBinding.btnSearch.setOnClickListener {
            viewModel.getPokemon(viewBinding.etName.text.toString())
        }
    }

    private fun observe() {
        viewModel.isLoading.observe(viewLifecycleOwner) {
            viewBinding.cpiLoading.isVisible = it
        }
        viewModel.pokemon.observe(viewLifecycleOwner) {
            viewBinding.tvName.text = it.name
            viewBinding.tvBaseExperience.text = it.baseExperience.toString()
            viewBinding.tvHeight.text = it.height.toString()
            viewBinding.tvWeight.text = it.weight.toString()
        }
        viewModel.showErrorEvent.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Ошибка в попе шишка", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
