package com.choius323.afreecatest.ui.broad.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.choius323.afreecatest.databinding.ItemRvBroadBinding
import com.choius323.domain.model.Broad

class BroadRecyclerViewAdapter(
    private val clickListener: (Broad?) -> Unit
) : PagingDataAdapter<Broad, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemRvBroadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = BroadViewHolder(binding)
        binding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                clickListener(getItem(position))
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BroadViewHolder -> holder.bind(getItem(position))
        }
    }

    class BroadViewHolder(private val binding: ItemRvBroadBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(broad: Broad?) {
            binding.broad = broad
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Broad>() {
            override fun areItemsTheSame(oldItem: Broad, newItem: Broad): Boolean {
                return oldItem.num == newItem.num
            }

            override fun areContentsTheSame(oldItem: Broad, newItem: Broad): Boolean {
                return oldItem == newItem
            }
        }
    }
}