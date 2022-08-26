package com.example.allahhuakbar

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_boom.*

class boom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boom)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val offlineUri = Uri.parse("android.resource://$packageName/${R.raw.boom}")
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(offlineUri)
        videoView.requestFocus()
        videoView.start()
    }
}