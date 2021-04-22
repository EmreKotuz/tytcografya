package com.kotuzapp.tytcografya

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.tytcografya.R
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_cografya_ana_sayfa.*
import kotlinx.android.synthetic.main.activity_kisa_notlar.*
import kotlinx.android.synthetic.main.activity_whats_app.*
import java.util.*


const val GAME_LENeGTH_MeILLISECONDSae = 3000L
const val AD_UeNIT_eIDae = "ca-app-pub-6537190103014639/7895118309"

class kisaNotlarActivity : AppCompatActivity() {
    private var mAdView: AdView? = null

    var sayi:Int=0
    val randommmm= arrayListOf(R.mipmap.atmo,R.mipmap.buyharoz,R.mipmap.dalol
        ,R.mipmap.dunyas,R.mipmap.dunyason,R.mipmap.dunyasong
        ,R.mipmap.ekfa,R.mipmap.erz,R.mipmap.harc,R.mipmap.icg
        ,R.mipmap.izo,R.mipmap.meridyen,R.mipmap.meridyenoz
        ,R.mipmap.orm,R.mipmap.par,R.mipmap.paroz,R.mipmap.per
        ,R.mipmap.renk,R.mipmap.volk,R.mipmap.yagis,R.mipmap.yasd
        ,R.mipmap.yerkure,R.mipmap.enkayy,R.mipmap.izoproc,R.mipmap.kromyat,R.mipmap.merboyy
        ,R.mipmap.mevic,R.mipmap.nuart,R.mipmap.ozkonumm,R.mipmap.taryon,R.mipmap.tutuet
        ,R.mipmap.ulyolll,R.mipmap.yilhar,R.mipmap.yurtgoc)

    //reklam kodu

    private lateinit var mInterstitialAd: InterstitialAd
    private var mCountDownTimer: CountDownTimer? = null
    private var mGameIsInProgress = false
    private var mTimerMilliseconds = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kisa_notlar)

        whatsapp.setOnClickListener {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://chat.whatsapp.com/GRZSUy3EFbLKzOemS6ZRKk")
                startActivity(openURL)

        }

        buttonBas.setOnClickListener{
            val random = Random()
            val button = random.nextInt(randommmm.count())
            imageee.setImageResource(randommmm[button])

            sayi++

            if (sayi==15){
                sayi=0
                showInterstitial()

            }
        }

        val random = Random()
        val button = random.nextInt(randommmm.count())
        imageee.setImageResource  (randommmm[button])





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



        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this)

        // Create the InterstitialAd and set it up.
        mInterstitialAd = InterstitialAd(this).apply {
            adUnitId = AD_UeNIT_eIDae
            adListener = (object : AdListener() {
                override fun onAdLoaded() {
                }

                override fun onAdFailedToLoad(errorCode: Int) {

                }

                override fun onAdClosed() {

                    startGame()

                }
            })
        }

        // Create the "retry" button, which triggers an interstitial between game plays.



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
            Toast.makeText(this, "Lüten baglantınızı kontrol edip tekrar deneyiniz", Toast.LENGTH_SHORT).show()
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

        resumeGame(GAME_LENeGTH_MeILLISECONDSae)
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
