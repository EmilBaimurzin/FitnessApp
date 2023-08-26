package com.fitness.game.ui.screens.control

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitness.game.databinding.FragmentControlBinding
import com.fitness.game.domain.recyclerView.ControlAdapter
import com.fitness.game.ui.other.ViewBindingFragment

class FragmentControl :
    ViewBindingFragment<FragmentControlBinding>(FragmentControlBinding::inflate) {
    private val viewModel: ControlViewModel by viewModels()
    private val controlAdapter by lazy { ControlAdapter { viewModel.deleteProduct(it) } }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.add.setOnClickListener {
            if (getCalories().isNotBlank() && getName().isNotBlank()) {
                viewModel.addProduct(getName(), getCalories().toInt())
                binding.nameEditText.setText("")
                binding.calEditText.setText("")
            }
        }

        viewModel.list.observe(viewLifecycleOwner) {
            controlAdapter.items = it.toMutableList()
            controlAdapter.notifyDataSetChanged()

            var totalCal = 0
            it.forEach { product ->
                totalCal += product.calories
            }

            binding.calories.text = totalCal.toString()
        }
    }

    private fun initAdapter() {
        with(binding.controlRV) {
            adapter = controlAdapter
            layoutManager = LinearLayoutManager(requireContext()).also {
                it.orientation = LinearLayoutManager.VERTICAL
            }
            setHasFixedSize(true)
        }
    }

    private fun getCalories(): String = binding.calEditText.text.toString()
    private fun getName(): String = binding.nameEditText.text.toString()

}