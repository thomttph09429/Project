package com.poly.test.utils

import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.poly.test.activity.GradeOneActivity
import com.poly.test.activity.MainActivity
import com.poly.test.activity.SignupActivity

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


}
fun Context.intent() {
    startActivity(Intent(this, SignupActivity::class.java))
}
