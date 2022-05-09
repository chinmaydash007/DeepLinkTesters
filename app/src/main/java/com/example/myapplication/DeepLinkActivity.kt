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
                "https://vsyt.me/o/reimbursment?requestId=81429",
                "Opd Reimbursement Status"
            ),
            DeepLink(
                "https://vsyt.me/o/hra",
                "HRA"
            ),
            DeepLink(
                "https://vsyt.me/o/consult-gp",
                "Doc consultation - general physician"
            ),
            DeepLink(
                "https://vsyt.me/o/sync_wearables",
                "Sync wearables"
            ),
            DeepLink(
                "https://vsyt.me/o/log-meal",
                "Log meal"
            ),
            DeepLink(
                "https://vsyt.me/o/fitness-album",
                "Album Home"
            ),
            DeepLink(
                "https://vsyt.me/o/online-consults",
                "Online Consultation Vertical Page"
            ),
            DeepLink(
                "https://vsyt.me/o/offline-consults",
                "Offline Consultation Vertical Page"
            ),
            DeepLink(
                "https://vsyt.me/o/ahc",
                "Labs AHC Page"
            ),
            DeepLink(
                "https://vsyt.me/o/support",
                "Support"
            ),
            DeepLink(
                "https://vsyt.me/o/album/13",
                "Video Fitness Album Details (Album Id)"
            ),
            DeepLink(
                "https://vsyt.me/o/podcastDetails/22",
                "PodCast Album Details (Album Id)"
            ),
            DeepLink(
                "https://vsyt.me/o/albumHome",
                "Album Home"
            ),
            DeepLink(
                "https://vsyt.me/o/podcastHome",
                "PodCast Home"
            ),
            DeepLink(
                "https://vsyt.me/o/consult/280022",
                "Online Consult Chat Page"
            ),
            DeepLink(
                "https://vsyt.me/o/offline-consults/280022",
                "Offline Consult Status Page"
            ),
            DeepLink(
                "https://vsyt.me/o/labs",
                "Lab Home Page"
            ),
            DeepLink(
                "https://vsyt.me/o/labs/123",
                "Offline Consult Status Page"
            ),
            DeepLink(
                "https://vsyt.me/o/challenges",
                "Challenges Page"
            ),

            )
    }
}