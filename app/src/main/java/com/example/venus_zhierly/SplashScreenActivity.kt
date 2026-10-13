package com.example.venus_zhierly

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        AppCompatDelegate.setDefaultNightMode(
            if (sharedPref.getBoolean("isDark", false)) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )

        // Sudah login: langsung ke BaseActivity
        if (sharedPref.getBoolean("isLogin", false)) {
            startActivity(Intent(this, BaseActivity::class.java))
            finish()
            return
        }

        // Belum login: splash 2 detik, lalu ke AuthActivity
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }, 2000)
    }
}