package com.poly.test.data.local

import androidx.room.*
import com.poly.test.data.local.Quiz

@Dao
interface QuizDAO {
    @Query("SELECT*  FROM Quiz")
    fun getallQuiz(): List<Quiz>


    @Insert
    fun Insert(user: Quiz?)



}