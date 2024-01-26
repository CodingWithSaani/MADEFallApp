package com.parukh.madefallapp.Lecture260124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.parukh.madefallapp.R

class DFWActivity : AppCompatActivity(),Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dfwactivity)

        if(savedInstanceState==null)
        {
            findViewById<FragmentContainerView>(R.id.fragment_container).let {
                val parentFragment = ParentFragment()
                supportFragmentManager.beginTransaction().add(it.id,parentFragment).commit()
            }
        }
    }

    override fun sendData(data: String) {
        findViewById<FragmentContainerView>(R.id.fragment_container).let {
            val childFragment = ChildFragment.newInstance(data)
            supportFragmentManager.beginTransaction().replace(it.id,childFragment)
                .addToBackStack(null).commit()
        }
    }
}