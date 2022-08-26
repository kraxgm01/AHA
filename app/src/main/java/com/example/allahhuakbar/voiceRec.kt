package com.example.allahhuakbar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.telecom.RemoteConference
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult
import kotlinx.android.synthetic.main.activity_voice_rec.*
import java.util.*


class voiceRec : AppCompatActivity() {

    private val RQ_SPEECH_REC = 102

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voice_rec)

        voiceBtn.setOnClickListener{
            askSpeechInput()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==RQ_SPEECH_REC && resultCode== Activity.RESULT_OK)
        {
            val result=data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            textBox.text = result?.get(0).toString()
            if(textBox.text == "Allah Hu Akbar" || textBox.text=="Allahu Akbar"){
            val intent = Intent(this,boom::class.java)
            startActivity(intent)
            }
        }
    }
    private fun askSpeechInput(){
        if(!SpeechRecognizer.isRecognitionAvailable(this)){
            Toast.makeText(this, "Speech Recognition not available!", Toast.LENGTH_SHORT).show()
        }else{
            val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault())
            i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say Something!")
            startActivityForResult(i,RQ_SPEECH_REC)
        }
    }


}