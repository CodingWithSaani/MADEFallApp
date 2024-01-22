package com.parukh.madefallapp.Lecture220124

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parukh.madefallapp.R
import com.parukh.madefallapp.databinding.ActivityBractivityBinding

class BRActivity : AppCompatActivity() {
    private lateinit var mBRActivityBinding:ActivityBractivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBRActivityBinding = ActivityBractivityBinding.inflate(layoutInflater)

        setContentView(mBRActivityBinding.root)
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)

        registerReceiver(ourBR,intentFilter)
    }

    private val ourBR = object :BroadcastReceiver()
    {
        override fun onReceive(context: Context?, intent: Intent?) {
            when(intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                WifiManager.WIFI_STATE_UNKNOWN))
            {
               WifiManager.WIFI_STATE_ENABLED->{
                   mBRActivityBinding.brTv.text ="Wifi is enabled"
               }
                WifiManager.WIFI_STATE_DISABLED->{
                    mBRActivityBinding.brTv.text ="Wifi is disabled"
                }
            }
        }

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(ourBR)
    }
}








