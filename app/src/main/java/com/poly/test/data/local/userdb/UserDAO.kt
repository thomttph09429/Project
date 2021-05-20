package com.poly.test.data.local.userdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {
    @Query("SELECT*  FROM user")
    fun getAllUser(): List<User>?

    @Insert()
    fun insertUser(user: User)

    @Query("SELECT * FROM user where name= :username and pass= :password")
    fun loGin(username: String, password: String): Boolean


}