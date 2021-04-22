package com.kotuzapp.tytcografya

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.tytcografya.R
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_harita_sozlu.*
import kotlinx.android.synthetic.main.activity_harita_sozlu.doğruBir
import kotlinx.android.synthetic.main.activity_harita_sozlu.doğruDört
import kotlinx.android.synthetic.main.activity_harita_sozlu.doğruIki
import kotlinx.android.synthetic.main.activity_harita_sozlu.doğruUc
import kotlinx.android.synthetic.main.activity_harita_sozlu.sayimButton
import kotlinx.android.synthetic.main.activity_harita_sozlu.sinaviBaslat
import kotlinx.android.synthetic.main.activity_harita_sozlu.yanlisDört
import kotlinx.android.synthetic.main.activity_harita_sozlu.yanlisIki
import kotlinx.android.synthetic.main.activity_harita_sozlu.yanlisUc
import kotlinx.android.synthetic.main.activity_harita_sozlu.yansısBir
import kotlinx.android.synthetic.main.activity_toprak_tipleri_sozlu.*

const val GAME_LENeGTH_MILLISECONDSa = 3000L
const val AD_UNIeT_IDa = "ca-app-pub-6537190103014639/7895118309"

class toprakTipleriSozlu : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd
    private var mCountDownTimer: CountDownTimer? = null
    private var mGameIsInProgress = false
    private var mTimerMilliseconds = 0L


    var time:Long=80    //10'dan başlamak için

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toprak_tipleri_sozlu)

        //dostum sayıyı geriye alarak saymaya yarıyor.

        sinaviBaslat.setOnClickListener {
            sinaviBaslat.text="Sınav Başlamıştır "


            object : CountDownTimer(time * 1000, 1000) {
                override fun onFinish() {

                    bitiş()
                    rekler()
                }

                override fun onTick(p0: Long) {
                    sinaviBaslat.setOnClickListener {
                        Toast.makeText(
                            this@toprakTipleriSozlu, "Sınav bir kere başlar :)",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    bitmedi()
                }
            }.start()



        }


        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this)

        // Create the InterstitialAd and set it up.
        mInterstitialAd = InterstitialAd(this).apply {
            adUnitId = AD_UNIeT_IDa
            adListener = (object : AdListener() {
                override fun onAdLoaded() {
                }

                override fun onAdFailedToLoad(errorCode: Int) {

                }

                override fun onAdClosed() {
                    startGame()
                    gizle()
                    rekler()

                    sinaviBaslat.text="cevapları kontrol ediniz :)"
                }
            })
        }


        // Create the "retry" button, which triggers an interstitial between game plays.
        sinaviBitir6.setOnClickListener { showInterstitial() }



        // Kick off the first play of the "game."
        startGame()
    }


    // Create the game timer, which counts down to the end of the level
    // and shows the "retry" button.
    private fun createTimer(milliseconds: Long) {
        mCountDownTimer?.cancel()

        mCountDownTimer = object : CountDownTimer(milliseconds, 50) {
            override fun onTick(millisUntilFinished: Long) {
                mTimerMilliseconds = millisUntilFinished
            }

            override fun onFinish() {
                mGameIsInProgress = false
            }
        }
    }

    // Show the ad if it's ready. Otherwise toast and restart the game.
    private fun showInterstitial() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        } else {
            Toast.makeText(this, "keşke internetin açık olsaydı :(", Toast.LENGTH_SHORT).show()
            startGame()
            gizle()
            rekler()

            sinaviBaslat.text="cevapları kontrol ediniz :)"
        }
    }

    // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
    private fun startGame() {
        if (!mInterstitialAd.isLoading && !mInterstitialAd.isLoaded) {
            // Create an ad request. If you're running this on a physical device, check your logcat
            // to learn how to enable test ads for it. Look for a line like this one:
            // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
            val adRequest = AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build()

            mInterstitialAd.loadAd(adRequest)


        }

        resumeGame(GAME_LENeGTH_MILLISECONDSa)
    }

    private fun resumeGame(milliseconds: Long) {
        // Create a new timer for the correct length and start it.
        mGameIsInProgress = true
        mTimerMilliseconds = milliseconds
        createTimer(milliseconds)
        mCountDownTimer?.start()
    }

    // Resume the game if it's in progress.
    public override fun onResume() {
        super.onResume()

        if (mGameIsInProgress) {
            resumeGame(mTimerMilliseconds)
        }
    }

    // Cancel the timer if the game is paused.
    public override fun onPause() {
        mCountDownTimer?.cancel()
        super.onPause()
    }


    private fun bitmedi(){
        time--
        sayimButton.text = "Kalan Süre: ${time} saniye "
    }

    private fun bitiş(){
        time=0
        sayimButton.text="Yanlışlarını gözden geçir :)"


    }
    private fun rekler(){

        yansısBir.setTextColor(Color.GREEN)
        doğruBir.setTextColor(Color.RED)
        yanlisIki.setTextColor(Color.RED)
        doğruIki.setTextColor(Color.GREEN)
        yanlisUc.setTextColor(Color.RED)
        doğruUc.setTextColor(Color.GREEN)
        yanlisDört.setTextColor(Color.RED)
        doğruDört.setTextColor(Color.GREEN)
    }
    private fun göster(){
        sayimButton.visibility= View.VISIBLE
    }
    private fun gizle(){
        sayimButton.visibility= View.INVISIBLE
    }

}

