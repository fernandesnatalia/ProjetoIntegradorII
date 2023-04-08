package com.example.projetointegradorii.ui.contact.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.projetointegradorii.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
    private lateinit var binding: FragmentContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bvSend.setOnClickListener{
            binding.ivSendMessageImage.isVisible = true
            binding.ivSendMessageText.isVisible = true
            binding.ivReturnSoon.isVisible = true

            binding.etName.isVisible = false
            binding.etPhone.isVisible = false
            binding.etMessage.isVisible = false
            binding.bvSend.isVisible = false
        }
    }
}