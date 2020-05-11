package com.example.future.soundplayerkotlin

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder

class MyService : Service() {
    var mediaPlayer: MediaPlayer? = null

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val btn: String = intent!!.getStringExtra("btn")
        if (btn.equals("play")) {
            var url: String = intent.getStringExtra("music")
            mediaPlayer = MediaPlayer.create(applicationContext, Uri.parse(url))
        } else if (btn.equals("back")) {
            if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                if (mediaPlayer!!.getDuration() - mediaPlayer!!.getCurrentPosition() > 5000) {
                    mediaPlayer!!.seekTo(mediaPlayer!!.getCurrentPosition() - 5000);
                } else {
                    mediaPlayer!!.stop();

                }
            }
        } else {
            if (mediaPlayer != null && mediaPlayer!!.isPlaying()) {
                if (mediaPlayer!!.getDuration() - mediaPlayer!!.getCurrentPosition() > 5000) {
                    mediaPlayer!!.seekTo(mediaPlayer!!.getCurrentPosition() + 5000);
                } else {
                    mediaPlayer!!.stop();
                }
            }
        }
            return super.onStartCommand(intent, flags, startId)
        }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer!!.stop()
    }
}
