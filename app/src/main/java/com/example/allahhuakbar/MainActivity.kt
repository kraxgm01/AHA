package com.example.allahhuakbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openVoiceRec(view: android.view.View) {
        val intent = Intent(this,voiceRec::class.java)
        startActivity(intent)
    }
}