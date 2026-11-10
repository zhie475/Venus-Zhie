package com.example.venus_zhierly.Message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.venus_zhierly.Home.pertemuan_11.TutorialMessageActivity
import com.example.venus_zhierly.R

class MessageFragment : Fragment() {

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://i.pravatar.cc/150?img=1", "21:00"),
        MessageModel("Budi", "Sudah makan?", "https://i.pravatar.cc/150?img=2", "22:00"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://i.pravatar.cc/150?img=3", "20:00"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://i.pravatar.cc/150?img=4", "23:00"),
        MessageModel("Eka", "Nice job kemarin!", "https://i.pravatar.cc/150?img=5", "21:00"),
        MessageModel("Fajar", "Lagi ngapain?", "https://i.pravatar.cc/150?img=6", "24:00"),
        MessageModel("Gita", "Boleh minta tolong?", "https://i.pravatar.cc/150?img=7", "20:00"),
        MessageModel("Hana", "Lihat email ya", "https://i.pravatar.cc/150?img=8", "22:00"),
        MessageModel("Irfan", "Oke noted", "https://i.pravatar.cc/150?img=9", "25:00"),
        MessageModel("Joko", "Sampai jumpa besok", "https://i.pravatar.cc/150?img=10", "23:00")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Toolbar
        val activity = requireActivity() as AppCompatActivity
        activity.setSupportActionBar(view.findViewById<Toolbar>(R.id.toolbar))
        activity.supportActionBar?.apply {
            title = "Message"
        }

        setHasOptionsMenu(true)

        // Setup Custom Adapter
        val listView = view.findViewById<ListView>(R.id.listMessageItems)
        listView.adapter = MessageAdapter(requireContext(), messageList)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                startActivity(Intent(requireContext(), TutorialMessageActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}