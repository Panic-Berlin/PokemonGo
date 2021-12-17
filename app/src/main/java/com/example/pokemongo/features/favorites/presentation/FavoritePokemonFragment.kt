package com.example.pokemongo.features.favorites.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokemongo.R
import com.example.pokemongo.appComponent
import com.example.pokemongo.databinding.FragmentFavoritePokemonBinding
import com.example.pokemongo.factory.ViewModelFactory
import com.example.pokemongo.features.favorites.di.DaggerFavoritePokemonComponent
import com.example.pokemongo.features.favorites.presentation.adapter.FavoritePokemonAdapter
import javax.inject.Inject

class FavoritePokemonFragment : Fragment(R.layout.fragment_favorite_pokemon) {

    private val viewBinding: FragmentFavoritePokemonBinding by viewBinding(
        FragmentFavoritePokemonBinding::bind
    )

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: FavoritePokemonViewModel by viewModels(
        factoryProducer = { viewModelFactory }
    )

    private val pokemonAdapter = FavoritePokemonAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerFavoritePokemonComponent.builder()
            .context(appComponent.context)
            .build()
            .inject(this)
        initViews()
        observe()

    }

    private fun initViews() {
        val pokemonRecyclerView = viewBinding.rvPokemon
        pokemonRecyclerView.layoutManager = GridLayoutManager(context, 2)
        pokemonRecyclerView.adapter = pokemonAdapter
    }

    private fun observe(){
        viewModel.readAllData.observe(viewLifecycleOwner){
            pokemonAdapter.setData(it)
        }
    }
}
