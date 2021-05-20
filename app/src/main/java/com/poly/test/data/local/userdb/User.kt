package com.poly.test.data.local.userdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey (autoGenerate = true)var id: Int,
    @ColumnInfo var name: String,
    @ColumnInfo var pass: String

){



}

