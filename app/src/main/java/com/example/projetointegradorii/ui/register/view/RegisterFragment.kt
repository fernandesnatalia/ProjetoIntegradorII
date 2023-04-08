package com.example.projetointegradorii.ui.register.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegradorii.R
import com.example.projetointegradorii.databinding.FragmentRegisterBinding
import com.example.projetointegradorii.ui.register.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
        binding.bvEnter.setOnClickListener {
            getData()
        }
    }
    private fun getData() {
        val name = binding.etInsertName
        val email = binding.etInsertEmail
        val pass = binding.etInsertPassword
        viewModel.validate(name,email, pass)

    }
    private fun observer(){
        viewModel.register.observe(this.viewLifecycleOwner){ goToHome() }

        viewModel.error.observe(this.viewLifecycleOwner){
            Toast.makeText(this.context, it, Toast.LENGTH_LONG).show()
        }
    }
    private fun goToHome(){
        NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment_to_messagesFragment)
    }
}