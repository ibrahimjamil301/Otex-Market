package com.example.otex_app_test.Activites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.otex_app_test.Adapter.FilteringAdapter
import com.example.otex_app_test.Models.MainViewModel
import com.example.otex_app_test.databinding.ActivityFiltringBinding
class FiltringActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFiltringBinding
    private lateinit var viewModel: MainViewModel
    private  val filteringAdapter = mutableListOf<FilteringAdapter>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltringBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setupRecyclerViews()

        binding.closeBtn.setOnClickListener {
            navigateBackToSource()
        }
        binding.resetBtn.setOnClickListener {
            resetToDefault()
        }
    }
    private fun setupRecyclerViews() {
        setupRecycler(binding.categoryRV, "type")
        setupRecycler(binding.categoryRecyclerView1, "numberOfRooms")
        setupRecycler(binding.categoryRecyclerView2, "paymentMethod")
        setupRecycler(binding.categoryRecyclerView3, "propertyCondition")
    }
    private fun setupRecycler(recyclerView: RecyclerView, type: String) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        viewModel.getFilteringByType(type).observe(this) { filteringList ->
            val adapter = FilteringAdapter(filteringList.toMutableList())
            recyclerView.adapter = adapter
            filteringAdapter.add(adapter)
        }
    }
    private fun resetToDefault() {
        filteringAdapter.forEach { adapter ->
            adapter.resetSelection()
        }
        binding.EditText.setText("")
        binding.EditText1.setText("")
        binding.maxPriceEditText1.setText("")
        binding.minPriceEditText1.setText("")

    }
    private fun navigateBackToSource() {
        val source = intent.getStringExtra("source")
        val destination = when (source) {
            "MainActivity" -> MainActivity::class.java
            "PlansActivity" -> PlansActivity::class.java
            else -> MainActivity::class.java
        }
        val intent = Intent(this, destination)
        startActivity(intent)
        finish()
    }
}