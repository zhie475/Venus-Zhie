package com.example.venus_zhierly.Home.pertemuan_11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.venus_zhierly.databinding.ActivityTutorialMessageBinding

class TutorialMessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTutorialMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TutorialMessageAdapter(this)
        binding.tutorialMessageViewPager.adapter = adapter
        binding.dotIndicator.attachTo(binding.tutorialMessageViewPager)
    }
}