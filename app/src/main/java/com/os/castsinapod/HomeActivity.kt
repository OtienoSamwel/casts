package com.os.castsinapod

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.os.castsinapod.databinding.ActivityHomeBinding
import com.os.castsinapod.ui.home.adapters.SearchAdapter
import com.os.castsinapod.ui.home.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityHomeBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recyclerView

        viewModel.getResults(binding.search.toString())
        
        binding.searchButton.setOnClickListener {
            viewModel.data.observe(this) {
                recyclerView.adapter = SearchAdapter(it, this)
            }
        }
    }
}