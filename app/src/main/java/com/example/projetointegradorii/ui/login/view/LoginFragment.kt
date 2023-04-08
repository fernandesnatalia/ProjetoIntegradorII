package com.example.projetointegradorii.ui.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegradorii.R
import com.example.projetointegradorii.databinding.FragmentLoginBinding
import com.example.projetointegradorii.ui.login.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
        binding.bvEnter.setOnClickListener {
            getData()
        }
    }
    private fun getData(){
        val email = binding.etEmail
        val pass = binding.etPassword
        viewModel.validate(email, pass)
    }

    private fun goToHome(){
        NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_messagesFragment)
    }
    private fun observer(){
        viewModel.login.observe(this.viewLifecycleOwner){ goToHome()}

        viewModel.error.observe(this.viewLifecycleOwner){
            Toast.makeText(this.context, it, Toast.LENGTH_LONG).show()
        }
    }
}

