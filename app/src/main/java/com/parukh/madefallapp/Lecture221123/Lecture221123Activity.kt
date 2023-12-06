package com.parukh.madefallapp.Lecture221123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.parukh.madefallapp.R
import com.parukh.madefallapp.databinding.ActivityLecture221123Binding

class Lecture221123Activity : AppCompatActivity() {

    /*
    1- Data Source
        list of random words
    2- Adapter
        ArrayAdapter
    3- Adapter View
        ListView
     */


    private lateinit var lec221123Binding:ActivityLecture221123Binding
    private val randomWordsList = mutableListOf("Hello","World","Today","is not ","raining","Lahore","Pakistan")

    private lateinit var randomWordsArrayAdapter:ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lec221123Binding = ActivityLecture221123Binding.inflate(layoutInflater)

        setContentView(lec221123Binding.root)
    }

    override fun onStart() {
        super.onStart()
        randomWordsArrayAdapter = ArrayAdapter(Lecture221123Activity@this,android.R.layout.simple_list_item_1,randomWordsList)

        lec221123Binding.randomWordsLv.adapter = randomWordsArrayAdapter
    }

}





















