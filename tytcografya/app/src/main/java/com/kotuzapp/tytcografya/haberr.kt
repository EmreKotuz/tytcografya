package com.kotuzapp.tytcografya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tytcografya.R
import kotlinx.android.synthetic.main.activity_haberr.*

class haberr : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haberr)

        webHaber.loadUrl("https://teknoek.com")

    }
}
