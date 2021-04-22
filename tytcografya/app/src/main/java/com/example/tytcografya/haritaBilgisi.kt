package com.example.tytcografya

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.*
import com.kotuzapp.tytcografya.haritaSozlu
import com.kotuzapp.tytcografya.motivasyonBirr
import kotlinx.android.synthetic.main.activity_harita_bilgisi.*

class haritaBilgisi : AppCompatActivity() {
    private var mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harita_bilgisi)



        haritaGeceModu.setOnClickListener {
            if (haritaGeceModu.isChecked) {
                haritaEkrann.setBackgroundColor(Color.parseColor("#6ADBC83D"))
                haritaGeceModu.text = "Gece modunu kapatmak için tıklayınız"
            } else {
                haritaEkrann.setBackgroundColor(Color.WHITE)
                haritaGeceModu.text = "Gece Modu"
            }
        }

        gizliBilgiBir.setOnClickListener {
            var intent=Intent(this,gizliBilgiHarita::class.java)
            startActivity(intent)
        }
        motivasyonBir.setOnClickListener {
            var intent= Intent(this,motivasyonBirr::class.java)
            startActivity(intent)
        }


        sözlüü.setOnClickListener {
            var intent= Intent(this,haritaSozlu::class.java)
            startActivity(intent)
        }
        MobileAds.initialize(this, "\n" + "ca-app-pub-6537190103014639~1020397464")
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView!!.loadAd(adRequest)


        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-6537190103014639/4128942386"

        mAdView!!.adListener = object : AdListener() {
            override fun onAdLoaded() {
            }

            override fun onAdFailedToLoad(errorCode: Int) {
            }

            override fun onAdOpened() {
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        }
    }
}
