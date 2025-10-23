package com.example.otex_app_test.Adapter

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.otex_app_test.R
import com.example.otex_app_test.data.local.entities.Plan
import com.example.otex_app_test.databinding.ItemPlanBinding

class PlanAdapter(
    private val plans: List<Plan>
) : RecyclerView.Adapter<PlanAdapter.ViewHolder>() {
    private lateinit var context: Context
    private var selectedPosition = RecyclerView.NO_POSITION
    inner class ViewHolder(private val binding: ItemPlanBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(plan: Plan, isSelected: Boolean) = with(binding) {

            planName.text = plan.name
            planPrice.text = plan.price
            planDuration.text = plan.duration
            planExtraInfo.text = plan.extraInfo
            planExtraInfo1.text = plan.extraInfo1
            planExtraInfo2.text = plan.extraInfo2
            planExtraInfo3.text = plan.extraInfo3
            planExtraInfo4.text = plan.extraInfo4
            tint1.text = plan.tint1
            bonusNumber.text = plan.bonusNumber
            bonusText.text = plan.bonusText
            ratingText.text = plan.ratingTxt

            feature1.visibility = getVisibility(plan.duration)
            feature2.visibility = getVisibility(plan.extraInfo)
            feature3.visibility = getVisibility(plan.extraInfo1)
            feature4.visibility = getVisibility(plan.extraInfo2)
            feature5.visibility = getVisibility(plan.extraInfo3)
            feature6.visibility = getVisibility(plan.extraInfo4)
            tint.visibility = getVisibility(plan.tint1)
            bonus.visibility = getVisibility(plan.bonusNumber)
            ratingLayout.visibility = getVisibility(plan.ratingTxt)

            updatePlanIcons(plan.name)

            planCheckBox.setOnCheckedChangeListener { _, isChecked ->
                updateCheckedStyle(isChecked)
            }
        }
        private fun getVisibility(value: String?): Int =
            if (value.isNullOrBlank()) View.GONE else View.VISIBLE
        private fun updateCheckedStyle(isChecked: Boolean) = with(binding) {
            val color = if (isChecked) "#3B4CF2" else "#000000"
            planName.setTextColor(Color.parseColor(color))
            planCheckBox.buttonTintList =
                ColorStateList.valueOf(Color.parseColor(color))
        }
        private fun updatePlanIcons(planName: String?) = with(binding) {
            when (planName) {
                "الباقة الأساسية" -> {
                    icon0.setImageResource(R.drawable.acute)
                }
                "أكسترا" -> {
                    icon0.setImageResource(R.drawable.acute)
                    icon1.setImageResource(R.drawable.rocket)
                    icon2.setImageResource(R.drawable.keep)
                }
                "بلس", "سوبر" -> {
                    icon0.setImageResource(R.drawable.acute)
                    icon1.setImageResource(R.drawable.rocket)
                    icon2.setImageResource(R.drawable.keep)
                    icon3.setImageResource(R.drawable.globe)
                    icon4.setImageResource(R.drawable.workspace_premium)
                    icon5.setImageResource(R.drawable.keep)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ItemPlanBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plan = plans[position]
        val isSelected = (position == selectedPosition)
        holder.bind(plan, isSelected)
    }
    override fun getItemCount(): Int = plans.size
}
