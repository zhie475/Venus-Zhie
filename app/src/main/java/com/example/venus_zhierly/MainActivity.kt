package com.example.venus_zhierly

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.venus_zhierly.databinding.ActivityMainBinding
import com.example.venus_zhierly.pertemuan2.SecondActivity
import com.example.venus_zhierly.pertemuan3.ThirdActivity
import com.example.venus_zhierly.pertemuan4.FourthActivity
import com.example.venus_zhierly.pertemuan_5.FifthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // SharedPreferences (nama harus sama dengan di AuthActivity)
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        // Tampilkan username di sapaan
        val username = sharedPref.getString("username", "")
        binding.tvHello.text = "Hello, $username!"

        // Navigasi menu
        binding.btnToSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding.btnToThird.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        binding.btnToFifth.setOnClickListener {
            startActivity(Intent(this, FifthActivity::class.java))
        }

        // Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }
}