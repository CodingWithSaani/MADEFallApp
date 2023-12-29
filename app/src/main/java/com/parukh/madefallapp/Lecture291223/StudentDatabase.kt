package com.parukh.madefallapp.Lecture291223

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StudentRecord::class], version = 1)
abstract class StudentDatabase: RoomDatabase() {

    abstract fun getStudentDao():StudentDAO
}