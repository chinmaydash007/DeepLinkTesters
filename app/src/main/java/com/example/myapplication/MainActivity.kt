package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.button.setOnClickListener {

            val clientId = binding.clientIdEditText.text.toString()
            val axisToken = binding.axisTokenEditText.text.toString()

            if (clientId.isBlank() || axisToken.isBlank()) {
                Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_SHORT).show()
            } else {
                val uri = Uri.parse("https://vsyt.me/visitoneaxis")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.putExtra("clientId", clientId.trim())
                intent.putExtra(
                    "oneaxistoken",
                    axisToken.trim()
                )
                startActivity(intent)

            }


        }


    }


//    val uri = Uri.parse("https://vsyt.me/visitoneaxis")
//    val intent = Intent(Intent.ACTION_VIEW, uri)
//    intent.putExtra("clientId", "axis-398fkj")
//    intent.putExtra(
//    "oneaxistoken",
//    "zWB4x0h6NmQswY6d65z4uOhfbgehmtCSnNScfAaFhcLtmS_bgDaTjbXTVBzRLAbs3_v8waiOJrInnpU3jCzACCuhs8EOaSkJnQPIe-8GSJhnIE_qJWlTwCZXL3Rt8cKF1IpLgup5ngfeoH2tpslm-g4yZgW1s9iPIVth-uC9qdE"
//    )
//    startActivity(intent)

}
//            val uri = Uri.parse("https://vsyt.me/reimbursment?requestId=942")
//            val intent = Intent(Intent.ACTION_VIEW, uri)
//            startActivity(intent)
