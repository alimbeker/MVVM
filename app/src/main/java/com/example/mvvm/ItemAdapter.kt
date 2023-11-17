package com.example.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.databinding.ItemDesignBinding
import com.example.mvvm.repository.Item

class ItemAdapter : ListAdapter<Item, ItemAdapter.ViewHolder>(ItemDiffUitls) {

    var itemClick: ((Item) -> Unit)? = null

    object ItemDiffUitls : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(private val binding: ItemDesignBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.title.text = item.title

            itemView.setOnClickListener {
                itemClick?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}