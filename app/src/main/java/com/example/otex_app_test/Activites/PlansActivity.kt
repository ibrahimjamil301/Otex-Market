package com.example.otex_app_test.Activites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.otex_app_test.Adapter.PlanAdapter
import com.example.otex_app_test.Models.MainViewModel
import com.example.otex_app_test.databinding.ActivityPlansBinding

class PlansActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlansBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var planAdapter: PlanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupRecyclerView()
        observeViewModel()
        setupClickListeners()

        viewModel.loadPlans()
    }
    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
    private fun setupRecyclerView() {
        binding.plansRecyclerView.apply {
            layoutManager = LinearLayoutManager(
                this@PlansActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            planAdapter = PlanAdapter(emptyList())
            adapter = planAdapter
        }
    }
    private fun observeViewModel() {
        viewModel.plans.observe(this) { plans ->
            planAdapter = PlanAdapter(plans)
            binding.plansRecyclerView.adapter = planAdapter
        }
    }
    private fun setupClickListeners() {
        binding.apply {
            backBtnMain.setOnClickListener {
                navigateTo(MainActivity::class.java, finishCurrent = true)
            }

            nextBtn.setOnClickListener {
                val intent = Intent(this@PlansActivity, FiltringActivity::class.java)
                intent.putExtra("source", "PlansActivity")
                startActivity(intent)
                finish()
            }
        }
    }
    private fun navigateTo(targetActivity: Class<*>, finishCurrent: Boolean = false) {
        startActivity(Intent(this, targetActivity))
        if (finishCurrent) finish()
    }
}
