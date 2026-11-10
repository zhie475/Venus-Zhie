package com.example.venus_zhierly.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.venus_zhierly.Home.pertemuan2.SecondActivity
import com.example.venus_zhierly.Home.pertemuan3.ThirdActivity
import com.example.venus_zhierly.Home.pertemuan4.FourthActivity
import com.example.venus_zhierly.Home.pertemuan7.SixthActivity
import com.example.venus_zhierly.Home.pertemuan_10.TenthActivity
import com.example.venus_zhierly.Home.pertemuan_5.FifthActivity
import com.example.venus_zhierly.Home.pertemuan_11.EleventhActivity
import com.example.venus_zhierly.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)

        // Sapaan dengan username
        val username = sharedPref.getString("username", "")
        binding.tvHello.text = if (username.isNullOrEmpty()) "Welcome!" else "Welcome, $username!"

        binding.btnToSecond.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnToThird.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        binding.btnToFifth.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }

        binding.btnToSixth.setOnClickListener {
            startActivity(Intent(requireContext(), SixthActivity::class.java))
        }

        binding.btnToTenth.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }

        binding.btnToEleventh.setOnClickListener {
            startActivity(Intent(requireContext(), EleventhActivity::class.java))
        }

        // Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}