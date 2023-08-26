package com.fitness.game.ui.screens

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.fitness.game.databinding.FragmentTrainingBinding
import com.fitness.game.ui.other.ViewBindingFragment

class FragmentTraining: ViewBindingFragment<FragmentTrainingBinding>(FragmentTrainingBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}