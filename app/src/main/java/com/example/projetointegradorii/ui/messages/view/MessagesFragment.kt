package com.example.projetointegradorii.ui.messages.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetointegradorii.data.entities.Message
import com.example.projetointegradorii.databinding.FragmentMessagesBinding
import com.example.projetointegradorii.domain.viewState.Status
import com.example.projetointegradorii.ui.messages.adapter.MessageAdapter
import com.example.projetointegradorii.ui.messages.viewmodel.MessageViewModel

class MessagesFragment : Fragment() {
    private lateinit var binding: FragmentMessagesBinding
    private lateinit var viewModel: MessageViewModel
    private val adapter: MessageAdapter by lazy { MessageAdapter(arrayListOf()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMessagesBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(MessageViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getList()
        observer()
    }
    private fun observer(){
        viewModel.list.observe(viewLifecycleOwner, Observer{
            when(it.status){
                Status.SUCCESS -> {
                    binding.rvMessages.adapter = adapter
                    binding.rvMessages.layoutManager = LinearLayoutManager(context)
                    adapter.updateList(it.data as ArrayList<Message>)
                    binding.rvMessages.isVisible = true
                    binding.pbLoading.isVisible = false
                }
                Status.LOADING -> {
                    binding.pbLoading.isVisible = true
                    binding.rvMessages.isVisible = false
                }
                Status.ERROR -> {
                    Toast.makeText( context,"${it.message}", Toast.LENGTH_LONG).show()
                    binding.pbLoading.isVisible = false
                }
            }
        })
    }
}