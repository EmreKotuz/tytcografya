package com.example.tytcografya

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.kotuzapp.tytcografya.kisaNotlarActivity
import kotlinx.android.synthetic.main.activity_ayarlar.*
import kotlinx.android.synthetic.main.activity_cografya_ana_sayfa.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var time:Long=10    //10'dan başlamak için
    val randommmm= arrayListOf(R.mipmap.agacekran,R.mipmap.colekran,R.mipmap.rainekran,R.mipmap.rainekrann)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arkaPlanResim.setOnClickListener {
            val random = Random()
            val button = random.nextInt(randommmm.count())
            arkaPlanResim.setBackgroundResource(randommmm[button])
        }

        val random = Random()
        val button = random.nextInt(randommmm.count())
        arkaPlanResim.setBackgroundResource(randommmm[button])

        başlatButton.setOnClickListener {
            var intent = Intent(this, cografyaAnaSayfa::class.java)
            startActivity(intent)
        }
        bizeYazin.setOnClickListener {
            var intent=Intent(this,ayarlar::class.java)
            startActivity(intent)
        }
        kisaNotlar.setOnClickListener {
            var intent=Intent(this,kisaNotlarActivity::class.java)
            startActivity(intent)
        }
    }
}
