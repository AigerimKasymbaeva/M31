package com.geeks.m31

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geeks.m31.databinding.ItemHomeBinding

class AnimalAdapter(
    private val animalList: ArrayList<Animal>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {
    class ViewHolder(
        private val binding: ItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Animal) {
            binding.txtTitle.text = animal.title
            Glide.with(binding.ivAnimal).load(animal.image).into(binding.ivAnimal)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(animalList[position])

        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
    }
}