package com.example.audio_mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.listening_beginner_a1)

        // Set completion listener to reset button text
        mediaPlayer.setOnCompletionListener {
            val playButton = findViewById<Button>(R.id.playButton)
            playButton.text = "Play"
        }
    }

    // Button click handler
    fun onPlayButtonClick(view: View) {
        val playButton = findViewById<Button>(R.id.playButton)

        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            playButton.text = "Play"
        } else {
            mediaPlayer.start()
            playButton.text = "Pause"
        }
    }
}
