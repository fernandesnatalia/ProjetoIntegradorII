package com.example.projetointegradorii.ui.services.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorii.data.entities.Service
import com.example.projetointegradorii.databinding.ItemBinding

class ServicesAdapter(
    private var list: List<Service>
): RecyclerView.Adapter<ServicesAdapter.ViewHolder>(){

    class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun showInfo(service: Service){
            binding.tvItem.text = service.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val service = list[position]
        holder.showInfo(service)
    }

    override fun getItemCount() = list.size

    fun updateList(newList:MutableList<Service>){
        list = newList
        notifyDataSetChanged()
    }
}