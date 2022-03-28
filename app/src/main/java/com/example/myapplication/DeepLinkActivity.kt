package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.adapter.DeepLinkListener
import com.example.myapplication.adapter.DeeplinkAdapter
import com.example.myapplication.databinding.DeepLinkActivityBinding
import com.example.myapplication.model.DeepLink

class DeepLinkActivity : AppCompatActivity(), DeepLinkListener {
    lateinit var binding: DeepLinkActivityBinding
    lateinit var adapter: DeeplinkAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_link)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_deep_link)
        adapter = DeeplinkAdapter(this)

        binding.recyclerView.adapter = adapter

        adapter.addDeeplink(getDeepLinkList())
    }

    override fun openDeeplink(url: String) {
        try {
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }


    fun getDeepLinkList(): List<DeepLink> {
        return listOf(
            DeepLink(
                "https://vsyt.me/reimbursment?requestId=81429",
                "Opd Reimbursement Status"
            ),
            DeepLink(
                "https://vsyt.me/hra",
                "HRA"
            ),
            DeepLink(
                "https://vsyt.me/consult-gp",
                "Doc consultation - general physician"
            ),
            DeepLink(
                "https://vsyt.me/o/sync_wearables",
                "Sync wearables"
            ),
            DeepLink(
                "https://vsyt.me/log-meal",
                "Log meal"
            ),
            DeepLink(
                "https://vsyt.me/fitness-album",
                "Album Home"
            ),
            DeepLink(
                "https://vsyt.me/online-consults",
                "Online Consultation Vertical Page"
            ),
            DeepLink(
                "https://vsyt.me/offline-consults",
                "Offline Consultation Vertical Page"
            )
        )
    }
}