package com.udacity.shoestore.views

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.viewmodels.ShoeFragmentViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private val viewModel: ShoeFragmentViewModel by activityViewModels()

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

            it.findNavController().navigateUp()
        }

        binding.btnSave.setOnClickListener {
            val shoeName: String = binding.etName.text.toString()
            val shoeSize: String = binding.etSize.text.toString()
            val shoeCompany: String = binding.etCompany.text.toString()
            val shoeDescription: String = binding.etDescription.text.toString()

            if (shoeName.isNotEmpty() && shoeCompany.isNotEmpty() && shoeCompany.isNotEmpty() && shoeSize.isNotEmpty()) {
                viewModel.addShoe(shoeName, shoeSize.toDouble(), shoeCompany, shoeDescription)
                it.findNavController().navigateUp()
            } else
                Toast.makeText(context, "Missing Fields", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}