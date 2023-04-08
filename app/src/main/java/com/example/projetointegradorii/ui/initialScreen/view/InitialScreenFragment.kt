package com.example.projetointegradorii.ui.initialScreen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegradorii.R
import com.example.projetointegradorii.databinding.FragmentInitialScreenBinding

class InitialScreenFragment : Fragment() {
    private lateinit var binding: FragmentInitialScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInitialScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bvEnter.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_initialScreenFragment_to_loginFragment)
        }
        binding.bvRegister.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_initialScreenFragment_to_registerFragment)
        }
    }
}