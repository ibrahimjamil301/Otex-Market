package com.example.otex_app_test.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.otex_app_test.data.local.entities.Brand
import com.example.otex_app_test.databinding.ViewholderBrandBinding

class BrandAdapter(private val brands: MutableList<Brand>) :
    RecyclerView.Adapter<BrandAdapter.ViewHolder>()  {
    private lateinit var context: Context
    inner class ViewHolder(val binding: ViewholderBrandBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(brand: Brand) {
            binding.title.text = brand.title
            binding.pic.setImageResource(brand.imageRes)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding =
        ViewholderBrandBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(brands[position])
    }
    override fun getItemCount(): Int = brands.size
    }