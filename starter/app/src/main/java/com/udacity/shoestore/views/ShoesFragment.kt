package com.udacity.shoestore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding

class ShoesFragment : Fragment() {

    private lateinit var binding: FragmentShoesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}