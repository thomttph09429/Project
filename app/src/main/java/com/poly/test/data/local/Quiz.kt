package com.poly.test.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "quiz")
class Quiz(
    @PrimaryKey var id: Int ,
    @ColumnInfo var question: String,
    @ColumnInfo var option1: String,
    @ColumnInfo var option2: String,
    @ColumnInfo var option3: String,
    @ColumnInfo var option4: String,
    @ColumnInfo var answer: Boolean= false


    ) {




}