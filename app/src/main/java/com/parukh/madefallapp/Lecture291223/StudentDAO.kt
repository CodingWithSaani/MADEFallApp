package com.parukh.madefallapp.Lecture291223

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Insert
    fun insertSingleStudentRecord(singleRecord:StudentRecord):Long

    @Query("select * from student_record")
    fun getAllStudentRecords():List<StudentRecord>
}