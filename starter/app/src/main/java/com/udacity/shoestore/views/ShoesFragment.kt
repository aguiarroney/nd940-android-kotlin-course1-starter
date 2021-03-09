package com.udacity.shoestore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeFragmentViewModel
import timber.log.Timber

class ShoesFragment : Fragment() {

    private lateinit var binding: FragmentShoesBinding
    private val viewModel: ShoeFragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_shoes, container, false)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {shoeList ->
            Timber.i("pegou a lista: ${shoeList}")

            shoeList.forEach { shoe ->
                val shoeItem: ShoeListItemBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_item, container, false)
                shoeItem.itemShoe = shoe
                binding.shoeList.addView(shoeItem.root)
            }
        })

        binding.fabShoe.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoesFragment_to_shoeDetailFragment)
        }

        return binding.root
    }
}