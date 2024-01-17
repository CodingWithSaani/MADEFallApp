package com.parukh.madefallapp.Lecture170124

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parukh.madefallapp.R
import com.parukh.madefallapp.databinding.ActivityServiceWorkingBinding

class ServiceWorkingActivity : AppCompatActivity() {

    private lateinit var mServiceWorkingBinding:ActivityServiceWorkingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mServiceWorkingBinding = ActivityServiceWorkingBinding.inflate(layoutInflater)
        setContentView(mServiceWorkingBinding.root)
    }

    override fun onStart() {
        super.onStart()

        mServiceWorkingBinding.serviceStartServiceBtn.setOnClickListener {

            startService(Intent(this,MyService::class.java))
        }
        mServiceWorkingBinding.serviceStopServiceBtn.setOnClickListener {
            stopService(Intent(this,MyService::class.java))
        }

    }
}














