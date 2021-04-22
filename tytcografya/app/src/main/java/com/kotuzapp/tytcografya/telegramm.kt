package com.kotuzapp.tytcografya

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tytcografya.R
import kotlinx.android.synthetic.main.activity_ayarlar.*
import kotlinx.android.synthetic.main.activity_telegramm.*

class telegramm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telegramm)






        telegramTikla.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://t.me/joinchat/NmjhCRaOCEgjQZaPGHAuRA")
            startActivity(openURL)
        }


    }

}
