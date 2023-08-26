package com.fitness.game.ui.pre

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.fitness.game.R
import com.fitness.game.databinding.FragmentNavigationStartBinding
import com.fitness.game.ui.other.ViewBindingFragment

class FragmentNavigationStart :
    ViewBindingFragment<FragmentNavigationStartBinding>(FragmentNavigationStartBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.start.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentChoice)
        }

        binding.privacyText.setOnClickListener {
            requireActivity().startActivity(
                Intent(
                    ACTION_VIEW,
                    Uri.parse("https://www.google.com")
                )
            )
        }
    }
}