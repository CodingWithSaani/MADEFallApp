package com.parukh.madefallapp.Lecture061223

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.parukh.madefallapp.R
import com.parukh.madefallapp.databinding.ActivityLocationBinding
import com.parukh.madefallapp.databinding.ActivityRecylcerBinding


/*
Step 1 : Create the model class
Step 2 : Create layout resource file for single_item
Step 3 : Create objects fo the model class and add those to the list
Step 4 : Create Recycler Adapter for the Model Class
     4.1 - Create user define class for recyclerview adapter
     4.2 - Create inner class of adapter view holder inside the class created in step 4.1
*/


class RecylcerActivity : AppCompatActivity() {

    val userList = mutableListOf<RVModel>(
        RVModel("Ali Raza","dummy@gmail.com"),
        RVModel("Ali Raza","dummy@gmail.com"),
        RVModel("Ali Raza","dummy@gmail.com"),
        RVModel("Ali Raza","dummy@gmail.com"),
        RVModel("Ali Raza","dummy@gmail.com"),
        RVModel("Ali Raza","dummy@gmail.com"),
        RVModel("Ali Raza","dummy@gmail.com"),
        RVModel("Ali Raza","dummy@gmail.com"),
        RVModel("Ali Raza","dummy@gmail.com"),
        RVModel("Ali Raza","dummy@gmail.com"),
        RVModel("Ali Raza","dummy@gmail.com"),
        RVModel("Ali Raza","dummy@gmail.com")
    )

    private lateinit var recyclerActivityBinding:ActivityRecylcerBinding
    private lateinit var rvAdapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerActivityBinding = ActivityRecylcerBinding.inflate(layoutInflater)

        setContentView(recyclerActivityBinding.root)
    }

    override fun onStart() {
        super.onStart()
        rvAdapter = RVAdapter(RecylcerActivity@this,userList)

        recyclerActivityBinding.rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerActivityBinding.rv.adapter = rvAdapter
    }
}













