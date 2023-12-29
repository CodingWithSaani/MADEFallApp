package com.parukh.madefallapp.Lecture291223

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

//student_record
@Entity(tableName = "student_record")
data class StudentRecord(
    @PrimaryKey @ColumnInfo(name = "student_id") val studentId:Int,
    val studentName:String,
    val studentEmail:String
)
