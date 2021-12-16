package com.example.pokemongo.features.start.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokemongo.App
import com.example.pokemongo.R
import com.example.pokemongo.databinding.FragmentStartBinding

class StartFragment : Fragment(R.layout.fragment_start) {

    private val viewBinding: FragmentStartBinding by viewBinding(FragmentStartBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        viewBinding.btnGo.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_menuFragment)
        }
    }
}
