package com.fitness.game.ui.choice

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.fitness.game.R
import com.fitness.game.databinding.FragmentChoiceBinding
import com.fitness.game.ui.other.ViewBindingFragment

class FragmentChoice: ViewBindingFragment<FragmentChoiceBinding>(FragmentChoiceBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            trainingLayout.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentChoice_to_fragmentTraining)
            }
            foodLayout.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentChoice_to_fragmentFood)
            }
            controlLayout.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentChoice_to_fragmentControl)
            }
            recommendationsLayout.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentChoice_to_fragmentRecommendations)
            }

            back.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}