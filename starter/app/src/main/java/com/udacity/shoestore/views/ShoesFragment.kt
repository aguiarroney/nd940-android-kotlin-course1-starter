package com.udacity.shoestore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.viewmodels.ShoeFragmentViewModel
import timber.log.Timber

class ShoesFragment : Fragment() {

    private lateinit var binding: FragmentShoesBinding
    private lateinit var viewModel: ShoeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_shoes, container, false)

        viewModel = ViewModelProvider(this).get(ShoeFragmentViewModel::class.java)

        viewModel.setTeste("mudou o observer")

        viewModel.teste.observe(viewLifecycleOwner, Observer {
            Timber.i("Observou ${it}")
        })

        return binding.root
    }
}