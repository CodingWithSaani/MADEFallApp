package com.parukh.madefallapp.Lecture271123

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.parukh.madefallapp.R
import com.parukh.madefallapp.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {
    private lateinit var locationActivityBinding:ActivityLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locationActivityBinding = ActivityLocationBinding.inflate(layoutInflater)

        setContentView(locationActivityBinding.root)
    }

    override fun onStart() {
        super.onStart()
        locationActivityBinding.getLocationBtn.setOnClickListener {

            getLocationUpdatesFromUser()

        }

    }

    private fun getLocationUpdatesFromUser() {

        if(
            ActivityCompat.checkSelfPermission(applicationContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION)==
            PackageManager.PERMISSION_GRANTED
        )
        {
          //get the location
        }
        else
        {
            //request the location
            ActivityCompat.requestPermissions(
                LocationActivity@this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                111
            )
        }
    }
}












