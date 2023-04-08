package com.example.projetointegradorii.ui.messages.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorii.data.entities.Message
import com.example.projetointegradorii.databinding.ItemBinding

class MessageAdapter(
    private var list: List<Message>
): RecyclerView.Adapter<MessageAdapter.ViewHolder>(){

    class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun showInfo(message: Message){
            binding.tvItem.text = message.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = list[position]
        holder.showInfo(message)
    }

    override fun getItemCount() = list.size

    fun updateList(newList:MutableList<Message>){
        list = newList
        notifyDataSetChanged()
    }
}