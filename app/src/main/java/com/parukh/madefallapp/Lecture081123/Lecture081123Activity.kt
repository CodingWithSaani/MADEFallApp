package com.parukh.madefallapp.Lecture081123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.parukh.madefallapp.R

class Lecture081123Activity : AppCompatActivity() {

    private lateinit var firstValueET:EditText
    private lateinit var secondValueET:EditText

    private lateinit var addBtn:Button
    private lateinit var subBtn:Button

    private lateinit var mulBtn:Button
    private lateinit var divBtn:Button

    private lateinit var clearFieldsBtn:Button
    private lateinit var resultTV:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture081123)

        connectIt()
    }

    private fun connectIt()
    {
        firstValueET = findViewById(R.id.first_value_et)
        secondValueET = findViewById(R.id.second_value_et)

        addBtn= findViewById(R.id.add_value_btn)
        subBtn = findViewById(R.id.sub_value_btn)

        mulBtn = findViewById(R.id.mul_value_btn)
        divBtn = findViewById(R.id.divide_value_btn)

        resultTV = findViewById(R.id.result_tv)
        clearFieldsBtn = findViewById(R.id.refresh_content_btn)

        addBtn.setOnClickListener {
            addValues()
        }
    }


    private fun addValues()
    {
        if(firstValueET.text.toString().isNotEmpty() && secondValueET.text.toString().isNotEmpty())
        {
            var firstValue = firstValueET.text.toString().toInt()
            var secondValue = secondValueET.text.toString().toInt()

            var resultVar = firstValue + secondValue
            resultTV.text = resultVar.toString()

        }
        else
        {
            Toast.makeText(this,"Something went wrong",Toast.LENGTH_LONG).show()
        }
    }









}