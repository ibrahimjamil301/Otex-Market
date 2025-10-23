package com.example.otex_app_test.Activites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.otex_app_test.Adapter.BrandAdapter
import com.example.otex_app_test.Adapter.ItemAdapter
import com.example.otex_app_test.Adapter.RecommendedAdapter
import com.example.otex_app_test.Models.MainViewModel
import com.example.otex_app_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var brandAdapter: BrandAdapter
    private lateinit var recommendedAdapter: RecommendedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupRecyclerViews()
        observeViewModel()
        setupClickListeners()

        viewModel.loadItems()
        viewModel.loadBrands()
        viewModel.loadRecommended()
    }
    private fun setupRecyclerViews() {
        binding.apply {
            categoryRecyclerView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, true)

            categoryRecyclerView1.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, true)
            viewPopular.layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }
    private fun observeViewModel() {
        viewModel.items.observe(this) { itemList ->
            itemAdapter = ItemAdapter(itemList.toMutableList())
            binding.categoryRecyclerView.adapter = itemAdapter
        }

        viewModel.brands.observe(this) { brandList ->
            brandAdapter = BrandAdapter(brandList.toMutableList())
            binding.categoryRecyclerView1.adapter = brandAdapter
        }

        viewModel.recommended.observe(this) { recommendedList ->
            recommendedAdapter = RecommendedAdapter(recommendedList.toMutableList())
            binding.viewPopular.adapter = recommendedAdapter
        }
    }
    private fun setupClickListeners() {
        binding.apply {

            profileBtn.setOnClickListener {
                navigateTo(PlansActivity::class.java, finishCurrent = true)
            }
            backBtn.setOnClickListener {
                val intent = Intent(this@MainActivity, FiltringActivity::class.java)
                intent.putExtra("source", "MainActivity")
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
