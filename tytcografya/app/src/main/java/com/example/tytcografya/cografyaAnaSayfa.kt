package com.example.tytcografya

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kotuzapp.tytcografya.haberr
import com.kotuzapp.tytcografya.whatsApp
import kotlinx.android.synthetic.main.activity_cografya_ana_sayfa.*
import java.util.*

class cografyaAnaSayfa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cografya_ana_sayfa)


        eksikler.setOnClickListener {
            var intent=Intent(this,com.example.tytcografya.bizeYazin::class.java)
            startActivity(intent)
        }
        haberButton.setOnClickListener {
            var intent=Intent(this,haberr::class.java)
            startActivity(intent)
        }
        /*bitu.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data= Uri.parse("https://play.google.com/store/apps/details?id=com.kotuz.mesajbulutu")
            startActivity(openURL)
        }*/
           what.setOnClickListener {
               val openURL = Intent(Intent.ACTION_VIEW)
               openURL.data = Uri.parse("https://chat.whatsapp.com/GRZSUy3EFbLKzOemS6ZRKk")
               startActivity(openURL)
           }
            haritaBilgisi.setOnClickListener {
                var intent = Intent(this, com.example.tytcografya.haritaBilgisi::class.java)
                startActivity(intent)
            }
            dünyanınSekli.setOnClickListener {
                var intent = Intent(this, dunyaninSekli::class.java)
                startActivity(intent)
            }
            dogalAfet.setOnClickListener {
                var intent = Intent(this, dogalAfett::class.java)
                startActivity(intent)
            }
            icVeDis.setOnClickListener {
                var intent = Intent(this, icVeDisActivity::class.java)
                startActivity(intent)
            }
            toprak.setOnClickListener {
                var intent = Intent(this, toprakTipleri::class.java)
                startActivity(intent)
            }
            iklim.setOnClickListener {
                var intent = Intent(this, Iklim::class.java)
                startActivity(intent)
            }
            nüfus.setOnClickListener {
                var intent = Intent(this, nufus::class.java)
                startActivity(intent)
            }
            cevre.setOnClickListener {
                var intent = Intent(this, cevreVeInsan::class.java)
                startActivity(intent)
            }
            ulasim.setOnClickListener {
                var intent = Intent(this, ulasimm::class.java)
                startActivity(intent)
            }
            kronometree.setOnClickListener {
                var intent = Intent(this, com.kotuzapp.tytcografya.kronometree::class.java)
                startActivity(intent)
            }



    }

}
