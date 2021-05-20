package com.poly.test.data.local.userdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun userDAO(): UserDAO
    companion object {

        private var INSTANCE: UserDB? = null
        fun getDatabase(context: Context): UserDB {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context.applicationContext, UserDB::class.java, "listuser")
                        .allowMainThreadQueries().build()
            }
            return INSTANCE as UserDB

        }

    }

}