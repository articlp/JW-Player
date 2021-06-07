package com.example.jwplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jwplayer.pub.api.JWPlayer
import com.jwplayer.pub.api.configuration.PlayerConfig
import com.jwplayer.pub.view.JWPlayerView

class MainActivity : AppCompatActivity() {

    var player: JWPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playerView = findViewById<JWPlayerView>(R.id.jwplayer)

        //Asynchronously
        playerView.getPlayerAsync(this, lifecycle) {
            this.player = it
            val playerConfig = PlayerConfig.Builder()
                .file("http://cdn.jwplayer.com/manifests/u3tr1w67.m3u8")
                .build()
            player?.setup(playerConfig)
        }

        // synchronously
//        player = playerView.player;
//        val playerConfig = PlayerConfig.Builder()
//            .file("http://cdn.jwplayer.com/manifests/u3tr1w67.m3u8")
//            .build()
//        player?.setup(playerConfig);
    }
}