package com.kotuzapp.tytcografya

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tytcografya.R
import kotlinx.android.synthetic.main.activity_cografya_ana_sayfa.*
import kotlinx.android.synthetic.main.activity_cografya_ana_sayfa.what
import kotlinx.android.synthetic.main.activity_whats_app.*

class whatsApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whats_app)


       /* what.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://chat.whatsapp.com/GRZSUy3EFbLKzOemS6ZRKk")
            startActivity(openURL)
        }*/
        what3.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://chat.whatsapp.com/GRZSUy3EFbLKzOemS6ZRKk")
            startActivity(openURL)
        }

    }
}
