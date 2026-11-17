package com.example.venus_zhierly.Home.pertemuan_12

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.venus_zhierly.Data.Api.CatFactApiClient
import com.example.venus_zhierly.Data.Api.PhotoApiClient
import com.example.venus_zhierly.Home.Photo.PhotoAdapter
import com.example.venus_zhierly.databinding.ActivityTwelfthBinding
import kotlinx.coroutines.launch

class TwelfthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTwelfthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwelfthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvGallery.layoutManager = GridLayoutManager(this, 2)

        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }

        loadCatFact()
        loadPhoto()
    }

    private fun loadCatFact() {
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                binding.rvGallery.adapter = PhotoAdapter(photos)
            } catch (e: Exception) {
                Toast.makeText(this@TwelfthActivity, "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}