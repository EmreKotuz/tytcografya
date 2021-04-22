package com.kotuzapp.tytcografya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.tytcografya.R
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_gizli_bilgi_harita.*

const val GAME_iLEigNGTeH_MILLISECONDSaaaa = 3000L
const val AD_iUNeiIgTie_IDa = "ca-app-pub-6537190103014639/7895118309"

class gizliBilgiCevre : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd
    private var mCountDownTimer: CountDownTimer? = null
    private var mGameIsInProgress = false
    private var mTimerMilliseconds = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gizli_bilgi_cevre)
        girisYap.setOnClickListener {
            if (sifre.text.toString()=="4" || sifre.text.toString()=="4temmuz" || sifre.text.toString()=="4 Temmuz") {
                var intent= Intent(this,gizliBilgiCevreGiris::class.java)
                startActivity(intent)


            }else{
                Toast.makeText(this,"Parola Yanlış!", Toast.LENGTH_SHORT).show()
                sifre.text.clear()
                sifre.hint="tekrar dene"
            }
        }
        //dostum sayıyı geriye alarak saymaya yarıyor.


        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this)

        // Create the InterstitialAd and set it up.
        mInterstitialAd = InterstitialAd(this).apply {
            adUnitId = AD_iUNeiIgTie_IDa
            adListener = (object : AdListener() {
                override fun onAdLoaded() {
                }
                override fun onAdFailedToLoad(errorCode: Int) {
                }
                override fun onAdClosed() {
                    startGame()

                    sifre.setText("4 Temmuz")
                    Toast.makeText(application,"Cevap 4 Temmuz idi..", Toast.LENGTH_SHORT).show()
                }
            })
        }
        // Create the "retry" button, which triggers an interstitial between game plays.
        bilmiyorum.setOnClickListener { showInterstitial() }


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
            Toast.makeText(this, " İnternetinizle alakalı sorun yaşanıyor. :(", Toast.LENGTH_SHORT).show()
            startGame()


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

        resumeGame(GAME_iLEigNGTeH_MILLISECONDSaaaa)
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


}

