package com.fitness.game.domain.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fitness.game.databinding.ItemProductBinding
import com.fitness.game.domain.Product

class ControlAdapter(private val onItemClickListener: (Int) -> Unit) : RecyclerView.Adapter<ControlViewHolder>() {
    var items = mutableListOf<Product>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ControlViewHolder {
        return ControlViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ControlViewHolder, position: Int) {
        holder.bind(items[position])
        holder.onItemClickListener = onItemClickListener
    }

}

class ControlViewHolder(private val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    var onItemClickListener: ((Int) -> Unit)? = null

    fun bind(item: Product) {
        binding.calories.text = item.calories.toString()
        binding.name.text = item.name
        binding.removeButton.setOnClickListener {
            onItemClickListener?.invoke(item.id)
        }
    }
}