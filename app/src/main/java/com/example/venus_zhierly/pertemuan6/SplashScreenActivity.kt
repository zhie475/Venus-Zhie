package com.example.venus_zhierly.pertemuan6

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.venus_zhierly.AuthActivity
import com.example.venus_zhierly.MainActivity
import com.example.venus_zhierly.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        // Terapkan tema gelap/terang
        AppCompatDelegate.setDefaultNightMode(
            if (sharedPref.getBoolean("isDark", false)) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )

        // Sudah login: langsung ke MainActivity, splash tidak ditampilkan
        if (sharedPref.getBoolean("isLogin", false)) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        // Belum login: tampilkan splash 2 detik, lalu ke AuthActivity
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }, 2000)
    }
}