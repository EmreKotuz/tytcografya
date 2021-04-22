package com.example.tytcografya

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ayarlar.*
import kotlinx.android.synthetic.main.activity_main.*

class ayarlar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayarlar)
        bizeYaz.setOnClickListener {
            var intent =Intent(this,com.example.tytcografya.bizeYazin::class.java)
            startActivity(intent)
        }

        tmatematik.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data= Uri.parse("https://play.google.com/store/apps/details?id=com.matematik.emre4.a10admdamatematik")
            startActivity(openURL)
        }
        tmat.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://play.google.com/store/apps/details?id=com.matematik.emre4.tytmatematik")
            startActivity(openURL)
        }
        instagramAdres.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.instagram.com/kotuz.akademi/")
            startActivity(openURL)
        }
        tytCoğrafya.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://play.google.com/store/apps/details?id=com.kotuzapp.tytcografya")
            startActivity(openURL)
        }
        kardeşkanal.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.derscalisiyorum.com.tr")
            startActivity(openURL)
        }
    }

}
