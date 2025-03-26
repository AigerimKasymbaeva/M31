package com.geeks.m31

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.geeks.m31.databinding.FragmentDetailBinding
import com.geeks.m31.databinding.FragmentHomeBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() = with(binding) {
        arguments?.let { bundle ->
            val animal = bundle.getSerializable("animal") as Animal
            txtTitle.text = animal.title
            Glide.with(ivAnimal).load(animal.image).into(ivAnimal)
        }
    }
}