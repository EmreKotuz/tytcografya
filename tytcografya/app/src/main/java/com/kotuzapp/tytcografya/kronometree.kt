package com.kotuzapp.tytcografya

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.media.MediaPlayer
import android.view.View
import com.example.tytcografya.R
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_kronometree.*

class kronometree : AppCompatActivity() {
    private var mAdView: AdView? = null

    var mediaPlayer: MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kronometree)

        var zamaniDurdur:Long=0
        BaslaButtonn.setOnClickListener {
            kronometre.base= SystemClock.elapsedRealtime()+zamaniDurdur
            kronometre.start()
            BaslaButtonn.visibility=View.GONE
            DurdurButtonn.visibility=View.VISIBLE
            sifirlaButtonn.visibility=View.VISIBLE
            mediaPlayer = MediaPlayer.create(this, R.raw.sess)
            mediaPlayer?.start()
        }
        DurdurButtonn.setOnClickListener {
            zamaniDurdur = kronometre.base-SystemClock.elapsedRealtime()
            kronometre.stop()
            BaslaButtonn.visibility=View.VISIBLE
            DurdurButtonn.visibility=View.GONE
            mediaPlayer = MediaPlayer.create(this, R.raw.sess)
            mediaPlayer?.start()
            sifirlaButtonn.visibility=View.VISIBLE
        }
        sifirlaButtonn.setOnClickListener {
            zamaniDurdur=0
            kronometre.base = SystemClock.elapsedRealtime()
            kronometre.stop()
            BaslaButtonn.visibility=View.VISIBLE
            DurdurButtonn.visibility=View.GONE
            sifirlaButtonn.visibility=View.VISIBLE
            // DurdurButtonn.imageView.setImageDrawable(getDrawable(R.drawable.durdurbutton))

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
