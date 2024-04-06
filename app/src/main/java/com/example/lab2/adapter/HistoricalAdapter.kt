package com.example.lab2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.databinding.ListItemBinding
import com.example.lab2.model.Historical

class HistoricalAdapter: ListAdapter<Historical, HistoricalAdapter.Holder>(Comparator()) {
    class Holder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ListItemBinding.bind(view)

        fun bind(historical: Historical) = with(binding){
            name.text= historical.name
            title.text = historical.title
            born.text = historical.info.born
            died.text = historical.info.died
            instruments.text = historical.info.instruments
            birthName.text = historical.info.birthName
        }
    }
    class Comparator:DiffUtil.ItemCallback<Historical>(){
        override fun areItemsTheSame(oldItem: Historical, newItem: Historical): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Historical, newItem: Historical): Boolean {
            return oldItem == newItem
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}