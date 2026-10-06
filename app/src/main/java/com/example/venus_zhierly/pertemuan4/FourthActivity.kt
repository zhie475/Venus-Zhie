package com.example.venus_zhierly.pertemuan4

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.venus_zhierly.R
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth)

        // 1. Ambil data dari Intent
        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age", 0)

        // 2. Cetak log ke Logcat (Log.e agar teks berwarna merah)
        Log.e("Data Intent", "Nama: $name, Usia: $age, Asal: $from")

        val btnKembali = findViewById<Button>(R.id.btnKembali)
        val btnShowSnackbar = findViewById<Button>(R.id.btnShowSnackbar)
        val btnShowAlert = findViewById<Button>(R.id.btnShowAlert)

        btnKembali.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnShowSnackbar.setOnClickListener {
            Snackbar.make(findViewById(R.id.main), "Ini Snackbar", Snackbar.LENGTH_SHORT).show()
        }

        btnShowAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("AlertDialog")
                .setMessage("Ini contoh AlertDialog")
                .setPositiveButton("OK", null)
                .show()
        }
    }
}