package com.example.pokemongo.features.menu.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokemongo.R
import com.example.pokemongo.databinding.FragmentMenuBinding

class MenuFragment: Fragment(R.layout.fragment_menu) {

    private val viewBinding: FragmentMenuBinding by viewBinding(FragmentMenuBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        viewBinding.btnSearchPokemon.setOnClickListener {

        }

        viewBinding.btnRandomPokemon.setOnClickListener {

        }
    }
}
