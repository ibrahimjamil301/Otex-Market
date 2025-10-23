package com.example.otex_app_test.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.otex_app_test.R
import com.example.otex_app_test.data.local.entities.Item
import com.example.otex_app_test.databinding.ViewholderItemBinding

class ItemAdapter(
    private val items: MutableList<Item>
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private lateinit var context: Context
    private var selectedPosition = RecyclerView.NO_POSITION
    inner class ViewHolder(private val binding: ViewholderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item, isSelected: Boolean) {
            binding.itemTxt.text = item.name

            val textColor = if (isSelected) {
                R.color.item_color
            } else {
                R.color.gray_color
            }

            binding.itemTxt.setTextColor(ContextCompat.getColor(context, textColor))
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ViewholderItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        val isSelected = selectedPosition == position

        holder.bind(currentItem, isSelected)

        holder.itemView.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedPosition)
        }
    }
    override fun getItemCount(): Int = items.size
}
