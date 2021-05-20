package com.poly.test.viewModel

import android.app.Application
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.poly.test.data.local.userdb.User
import com.poly.test.data.local.userdb.UserDB
import com.poly.test.data.local.userdb.UserRepository
import com.poly.test.utils.Event
import com.poly.test.utils.SingleLiveData
import kotlinx.coroutines.launch


class SignupViewModel(app: Application) : AndroidViewModel(app) {
    companion object {
        const val SIGNUP_SUCCESS = 1
        const val SIGNUP_FAILURE = 2
        const val LOGIN = 3

    }

    lateinit var alluser: MutableLiveData<User>

    val name = MutableLiveData<String?>()
    val pass = MutableLiveData<String?>()


    val singliveData: SingleLiveData<Int>

    init {
        singliveData = SingleLiveData()

    }
    var message: String = ""
    fun saveUser() {
        if (name.value == "" || pass.value == "") {
            singliveData.value = SIGNUP_FAILURE
            message = "Please enter username and password"

        } else if (name.value !== null || pass.value !== null) {
            singliveData.value = SIGNUP_SUCCESS
            val username: String = name.value.toString()
            val password: String = pass.value.toString()
            insert((User(0, username, password)))
        }
    }

    fun insert(user: User) {
        val userDao = UserDB.getDatabase(getApplication()).userDAO()
        userDao?.insertUser(user)
    }

    fun loginUser() {
        val userDao = UserDB.getDatabase(getApplication()).userDAO()
        var x = userDao.loGin(name.value.toString(), pass.value.toString())
        if (x) {
            singliveData.value = SIGNUP_SUCCESS
            message = "login success"


        } else {
            singliveData.value = SIGNUP_FAILURE
            message = "login failed"

        }

    }

    fun onClickLogin() {
        singliveData.value = LOGIN

    }


}