package com.parukh.madefallapp.Lecture080124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.parukh.madefallapp.AppConstants
import com.parukh.madefallapp.R
import com.parukh.madefallapp.databinding.ActivityFirestoreBinding
import java.lang.Exception

class FirestoreActivity : AppCompatActivity() {

    private lateinit var mFirestoreActivity:ActivityFirestoreBinding
    private val mFirestore = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirestoreActivity = ActivityFirestoreBinding.inflate(layoutInflater)

        setContentView(mFirestoreActivity.root)
    }

    override fun onStart() {
        super.onStart()

        mFirestoreActivity.fsSaveRecordBtn.setOnClickListener {
            saveRecordIntoFirestoreCollection()
        }

        mFirestoreActivity.fsGetRecordBtn.setOnClickListener {
            getRecordFromFirestore()
        }
    }

    private fun getRecordFromFirestore() {
        try
        {
            mFirestoreActivity.fsProgressBar.visibility = View.VISIBLE
            val collectionAddress = mFirestore.collection(AppConstants.tempCollection)

            var retrievedData = ""
            collectionAddress.get().addOnSuccessListener {
                mFirestoreActivity.fsProgressBar.visibility = View.INVISIBLE
                for (singleRecord in it)
                {
                    retrievedData += "name : ${singleRecord.data.get("name")} \n" +
                            "email: ${singleRecord.data.get("email")} \n" +
                            "age: ${singleRecord.data.get("age")}"
                }

                mFirestoreActivity.fsRecordTv.text = retrievedData
            }.addOnFailureListener {
                mFirestoreActivity.fsProgressBar.visibility = View.INVISIBLE
                mFirestoreActivity.fsRecordTv.text = "Failed to get data because of ${it.message}"
            }
        }
        catch (ex:Exception)
        {
            mFirestoreActivity.fsProgressBar.visibility = View.INVISIBLE
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_LONG).show()
        }
    }

    private fun saveRecordIntoFirestoreCollection() {
        try
        {
           if(mFirestoreActivity.fsNameEt.text.isNotEmpty() and
               mFirestoreActivity.fsEmailEt.text.isNotEmpty() and
               mFirestoreActivity.fsAgeEt.text.isNotEmpty())
           {
               mFirestoreActivity.fsProgressBar.visibility = View.VISIBLE

               val userName = mFirestoreActivity.fsNameEt.text.toString()
               val userEmail = mFirestoreActivity.fsEmailEt.text.toString()

               val userAge = mFirestoreActivity.fsAgeEt.text.toString().toInt()
               val currentUser = hashMapOf(
                   "name" to userName,
                   "email" to userEmail,
                   "age" to userAge
               )

               val collectionAddress = mFirestore.collection(AppConstants.tempCollection)
               collectionAddress.add(currentUser).addOnSuccessListener {
                   mFirestoreActivity.fsProgressBar.visibility = View.INVISIBLE
                   Toast.makeText(applicationContext,"Document is added with id:${it.id}",Toast.LENGTH_SHORT).show()

                   mFirestoreActivity.fsNameEt.text.clear()
                   mFirestoreActivity.fsEmailEt.text.clear()

                   mFirestoreActivity.fsAgeEt.text.clear()
                   mFirestoreActivity.fsNameEt.requestFocus()

               }.addOnFailureListener {
                   mFirestoreActivity.fsProgressBar.visibility = View.INVISIBLE
                   mFirestoreActivity.fsRecordTv.text = "Failed to add data because of ${it.message}"
               }
           }
            else if(mFirestoreActivity.fsNameEt.text.isEmpty())
           {
               Toast.makeText(applicationContext,"Please enter the name",Toast.LENGTH_LONG).show()
               mFirestoreActivity.fsNameEt.requestFocus()
           }
           else if(mFirestoreActivity.fsEmailEt.text.isEmpty())
           {
               Toast.makeText(applicationContext,"Please enter the email",Toast.LENGTH_LONG).show()
               mFirestoreActivity.fsEmailEt.requestFocus()
           }
           else if(mFirestoreActivity.fsAgeEt.text.isEmpty())
           {
               Toast.makeText(applicationContext,"Please enter the age",Toast.LENGTH_LONG).show()
               mFirestoreActivity.fsAgeEt.requestFocus()
           }

        }
        catch (ex:Exception)
        {
            mFirestoreActivity.fsProgressBar.visibility = View.INVISIBLE
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_LONG).show()
        }
    }
}













