package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        binding.btnCancel.setOnClickListener {
            binding.etCompany.text.clear()
            binding.etDescription.text.clear()
            binding.etName.text.clear()
            binding.etSize.text.clear()

            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoesFragment)
        }

        binding.btnSave.setOnClickListener {
            //TODO add a new shoe do the list
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoesFragment)
        }

        return binding.root
    }
}