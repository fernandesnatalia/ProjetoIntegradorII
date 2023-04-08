package com.example.projetointegradorii.ui.services.view

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
import com.example.projetointegradorii.data.entities.Service
import com.example.projetointegradorii.databinding.FragmentServicesBinding
import com.example.projetointegradorii.domain.viewState.Status
import com.example.projetointegradorii.ui.services.adapter.ServicesAdapter
import com.example.projetointegradorii.ui.services.viewmodel.ServicesViewModel

class ServicesFragment : Fragment() {
    private lateinit var binding: FragmentServicesBinding
    private lateinit var viewModel: ServicesViewModel
    private val adapter: ServicesAdapter by lazy { ServicesAdapter(arrayListOf()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServicesBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(ServicesViewModel::class.java)
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
                    binding.rvServices.adapter = adapter
                    binding.rvServices.layoutManager = LinearLayoutManager(context)
                    adapter.updateList(it.data as ArrayList<Service>)
                    binding.rvServices.isVisible = true
                    binding.pbLoading.isVisible = false
                }
                Status.LOADING -> {
                    binding.pbLoading.isVisible = true
                    binding.rvServices.isVisible = false
                }
                Status.ERROR -> {
                    Toast.makeText( context,"${it.message}", Toast.LENGTH_LONG).show()
                    binding.pbLoading.isVisible = false
                }
            }
        })
    }
}