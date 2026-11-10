package com.example.venus_zhierly.Home.pertemuan_11

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.venus_zhierly.R
import com.example.venus_zhierly.databinding.ActivityEleventhBinding
import com.google.android.material.tabs.TabLayoutMediator

class EleventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEleventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEleventhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Toolbar + tombol back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 11"
            setDisplayHomeAsUpEnabled(true)
        }

        // 1. Inisialisasi Adapter
        val tabsAdapter = EleventhTabsAdapter(this)

        // 2. Set adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 3. Hubungkan TabLayout & ViewPager2, lengkap dengan icon dan badge
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab A"
                    tab.setIcon(R.drawable.ic_home) // Sesuaikan dengan nama icon di folder res/drawable
                }
                1 -> {
                    tab.text = "Tab B"
                    tab.setIcon(R.drawable.ic_home) // Sesuaikan dengan nama icon di folder res/drawable
                }
                2 -> {
                    tab.text = "Produk" // Atau "Tab C"
                    tab.setIcon(R.drawable.ic_home) // Pasang ikon untuk Tab Produk di sini
                }
            }
        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}