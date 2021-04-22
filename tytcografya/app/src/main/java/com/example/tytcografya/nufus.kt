package com.example.tytcografya

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.ads.*
import com.kotuzapp.tytcografya.gizliBilgiNufus
import com.kotuzapp.tytcografya.motivasyonBirr
import com.kotuzapp.tytcografya.nufusSozlu
import kotlinx.android.synthetic.main.activity_harita_bilgisi.*
import kotlinx.android.synthetic.main.activity_iklim.*
import kotlinx.android.synthetic.main.activity_nufus.*

class nufus : AppCompatActivity() {
    private var mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nufus)

        nufusButton.setOnClickListener {
            var intent= Intent(this,nufusSozlu::class.java)
            Toast.makeText(this,"Bu sayfada internet açık olması mecburidir :)", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        motivasyonYedi.setOnClickListener {
            var intent= Intent(this, gizliBilgiNufus::class.java)
            startActivity(intent)
        }

        nufusGece.setOnClickListener {
            if (nufusGece.isChecked) {
                nufusEkran.setBackgroundColor(Color.parseColor("#6ADBC83D"))
                nufusGece.text = "Gece modunu kapatmak için tıklayınız"
            } else {
                nufusEkran.setBackgroundColor(Color.WHITE)
                nufusGece.text = "Gece Modu"
            }
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
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
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
