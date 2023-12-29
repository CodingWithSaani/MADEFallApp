package com.parukh.madefallapp.Lecture291223

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.parukh.madefallapp.R
import com.parukh.madefallapp.databinding.ActivityRoomWorkingBinding

class RoomWorkingActivity : AppCompatActivity() {

    private lateinit var mRoomWorkingBinding:ActivityRoomWorkingBinding
    private lateinit var mStudentDatabase: StudentDatabase

    private var idCounter=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRoomWorkingBinding = ActivityRoomWorkingBinding.inflate(layoutInflater)
        setContentView(mRoomWorkingBinding.root)

    }

    override fun onStart() {
        super.onStart()
        mStudentDatabase = Room.databaseBuilder(applicationContext,StudentDatabase::class.java,
            "StudentDb").allowMainThreadQueries().build()

        val studentDao= mStudentDatabase.getStudentDao()

        mRoomWorkingBinding.rAddRecordBtn.setOnClickListener {
            idCounter++
            val currentStudent = StudentRecord(idCounter,"Ali Raza","ali@gmail.com")

            val check= studentDao.insertSingleStudentRecord(currentStudent)
            if(check!=0L)
            {
                Toast.makeText(this,"Record inserted",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"Record not inserted",Toast.LENGTH_LONG).show()
            }
        }

        mRoomWorkingBinding.rGetRecordBtn.setOnClickListener {
            val studentData = studentDao.getAllStudentRecords()

            if(studentData.isNotEmpty())
            {
                var data =""
                for(singleStudentRecord in studentData)
                {
                    data += "student id:${singleStudentRecord.studentId} \n" +
                            "student name:${singleStudentRecord.studentName} \n" +
                            "student email:${singleStudentRecord.studentEmail} \n"
                }

                mRoomWorkingBinding.rRecordTv.text = data
            }
            else
            {
                Toast.makeText(this,"No Record Found",Toast.LENGTH_LONG).show()
            }
        }
    }
}










