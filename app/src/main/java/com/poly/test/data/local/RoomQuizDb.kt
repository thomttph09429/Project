package com.poly.test.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quiz::class], version = 1)
abstract class RoomQuizDb : RoomDatabase() {

    abstract fun getquizDao(): QuizDAO

    companion object {
        private var INSTANCE: RoomQuizDb? = null
        fun getInstance(context: Context): RoomQuizDb {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    RoomQuizDb::class.java,
                    "quiztable").allowMainThreadQueries().build()

            }
            return INSTANCE as RoomQuizDb

        }

    }

}