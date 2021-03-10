package com.udacity.shoestore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import androidx.databinding.DataBindingUtil

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.btnLogin.setOnClickListener { view: View ->
            navigateToWelcome(view)
        }

        binding.btnSignIn.setOnClickListener { view: View ->
            navigateToWelcome(view)
        }

        return binding.root
    }

    private fun navigateToWelcome(v: View) {
        if(binding.etEmail.text.isNotEmpty() && binding.etPassword.text.isNotEmpty())
            v.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        else
            Toast.makeText(context, "Missing Fields", Toast.LENGTH_SHORT).show()
    }

}