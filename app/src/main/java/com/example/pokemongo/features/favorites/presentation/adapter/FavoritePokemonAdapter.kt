package com.example.pokemongo.features.favorites.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokemongo.R
import com.example.pokemongo.databinding.ItemPokemonBinding
import com.example.pokemongo.features.searchpokemon.data.entity.Pokemon

class FavoritePokemonAdapter() : RecyclerView.Adapter<FavoritePokemonAdapter.CustomViewHolder>() {

    private var pokemonList = emptyList<Pokemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val cellForPokemon =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return CustomViewHolder(cellForPokemon)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val viewBinding: ItemPokemonBinding by viewBinding(ItemPokemonBinding::bind)

        @SuppressLint("SetTextI18n")
        fun bind(pokemon: Pokemon){
            viewBinding.tvName.text ="Имя: ${pokemon.name}"
            viewBinding.tvBaseExperience.text = "Базовый опыт ${pokemon.baseExperience}"
            viewBinding.tvHeight.text = "Рост: ${pokemon.height}"
            viewBinding.tvWeight.text = "Вес: ${pokemon.weight}"
        }
    }

    fun setData(pokemon: List<Pokemon>){
        this.pokemonList = pokemon
        notifyDataSetChanged()
    }
}
