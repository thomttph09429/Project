package com.poly.test.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.poly.test.R
import com.poly.test.data.local.userdb.User
import com.poly.test.databinding.ActivitySignupBinding
import com.poly.test.utils.toast
import com.poly.test.utils.intent
import com.poly.test.viewModel.SignupViewModel


class SignupActivity : AppCompatActivity() {


    lateinit var viewModel: SignupViewModel
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        viewModel = ViewModelProvider(this).get(SignupViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.singliveData.observe(this, Observer {
            when (it) {
                SignupViewModel.SIGNUP_FAILURE -> showErr()
                SignupViewModel.SIGNUP_SUCCESS -> moveToHome()
                SignupViewModel.LOGIN->startLogin()

            }

        })

    }
    private fun showErr() {
        toast(viewModel.message)
    }

    private fun moveToHome() {
        startActivity(Intent(this, MainActivity::class.java))

    }
    private fun startLogin() {
        startActivity(Intent(this, LoginActivity::class.java))

    }
}