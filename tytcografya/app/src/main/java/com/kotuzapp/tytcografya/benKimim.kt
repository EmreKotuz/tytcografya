package com.kotuzapp.tytcografya

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tytcografya.R
import kotlinx.android.synthetic.main.activity_ben_kimim.*

class benKimim : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ben_kimim)
        istaa.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.instagram.com/emre.kotuz/")
            startActivity(openURL)
        }
    }
}
