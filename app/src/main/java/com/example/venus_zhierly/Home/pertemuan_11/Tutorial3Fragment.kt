package com.example.venus_zhierly.Home.pertemuan_11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.venus_zhierly.databinding.ActivityTutorial3Binding

class Tutorial3Fragment : Fragment() {
    private var _binding: ActivityTutorial3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityTutorial3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Aksi ketika tombol "Mulai" diklik
        binding.btnMulai.setOnClickListener {
            requireActivity().finish() // Menutup tutorial dan kembali ke halaman sebelumnya
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}