package com.example.tytcografya

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.*
import com.kotuzapp.tytcografya.gizliBilgiToprak
import com.kotuzapp.tytcografya.motivasyonBirr
import com.kotuzapp.tytcografya.toprakTipleriSozlu
import kotlinx.android.synthetic.main.activity_harita_bilgisi.*
import kotlinx.android.synthetic.main.activity_nufus.*
import kotlinx.android.synthetic.main.activity_toprak_tipleri.*

class toprakTipleri : AppCompatActivity() {
    private var mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toprak_tipleri)

        toprakSozlu.setOnClickListener {
            var intent = Intent(this,toprakTipleriSozlu::class.java)
            startActivity(intent)
        }
        motivasyonSekiz.setOnClickListener {
            var intent= Intent(this, gizliBilgiToprak::class.java)
            startActivity(intent)
        }

        toprakGece.setOnClickListener {
            if (toprakGece.isChecked) {
                toprakEkran.setBackgroundColor(Color.parseColor("#6ADBC83D"))
                toprakGece.text = "Gece modunu kapatmak için tıklayınız"
            } else {
                toprakEkran.setBackgroundColor(Color.WHITE)
                toprakGece.text = "Gece Modu"
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
