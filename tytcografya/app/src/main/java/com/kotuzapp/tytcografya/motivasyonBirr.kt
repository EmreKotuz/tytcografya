package com.kotuzapp.tytcografya

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.tytcografya.R
import com.example.tytcografya.cografyaAnaSayfa
import kotlinx.android.synthetic.main.activity_harita_bilgisi.*
import kotlinx.android.synthetic.main.activity_motivasyon_birr.*

class motivasyonBirr : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motivasyon_birr)


        muttlu.setOnClickListener {
            var intent= Intent(this,cografyaAnaSayfa::class.java)
            startActivity(intent)

            Toast.makeText(this," Hadi ne duruyorsun!",Toast.LENGTH_SHORT).show()
        }

        mutsuz.setOnClickListener {

            ActivityCompat.finishAffinity(this)
            Toast.makeText(this," Uygulamayı sil!",Toast.LENGTH_SHORT).show()


        }



    }
}
