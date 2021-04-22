package com.kotuzapp.tytcografya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tytcografya.R
import com.example.tytcografya.cografyaAnaSayfa
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_gizli_bilgi_dunya_giris.*

class gizliBilgiDogalAfetGiris : AppCompatActivity() {
    private var mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gizli_bilgi_dogal_afet_giris)

        anaSayfa.setOnClickListener {
            var intent= Intent(this, cografyaAnaSayfa::class.java)
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