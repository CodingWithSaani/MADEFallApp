package com.parukh.madefallapp.Lecture170124

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.IBinder
import android.widget.Toast

class MyService:Service() {

    private lateinit var mMediaPlayer: MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mMediaPlayer = MediaPlayer.create(this,RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))

        mMediaPlayer.isLooping = true
        mMediaPlayer.start()

        Toast.makeText(this,"Service is started",Toast.LENGTH_LONG).show()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mMediaPlayer.stop()
        Toast.makeText(this,"Service is stopped",Toast.LENGTH_LONG).show()
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}