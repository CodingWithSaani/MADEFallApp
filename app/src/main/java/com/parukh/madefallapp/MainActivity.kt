package com.parukh.madefallapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.parukh.madefallapp.Lecture061223.RecylcerActivity
import com.parukh.madefallapp.Lecture080124.FirestoreActivity
import com.parukh.madefallapp.Lecture081123.Lecture081123Activity
import com.parukh.madefallapp.Lecture170124.ServiceWorkingActivity
import com.parukh.madefallapp.Lecture220124.BRActivity
import com.parukh.madefallapp.Lecture221123.Lecture221123Activity
import com.parukh.madefallapp.Lecture271123.LocationActivity
import com.parukh.madefallapp.Lecture291223.RoomWorkingActivity

class MainActivity : AppCompatActivity() {

    private lateinit var uniTitle:TextView
    private lateinit var getValueET:TextView

    private lateinit var changeBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectToXML()

    }

    private fun connectToXML()
    {
        changeBtn = findViewById(R.id.change_btn)
        uniTitle = findViewById(R.id.uni_title)

        getValueET = findViewById(R.id.get_value_et)
        changeBtn.setOnClickListener {
            //changeUniTitle()

            startActivity(
                Intent(this,BRActivity::class.java)
            )
        }
    }

    private fun changeUniTitle() {
        if(getValueET.text.toString().isNotEmpty())
        {
            uniTitle.text = getValueET.text.toString()
        }
        else
        {
            uniTitle.text = "Please enter a valid value"
            getValueET.requestFocus()
        }
    }


}