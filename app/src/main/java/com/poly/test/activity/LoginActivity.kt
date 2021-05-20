package com.poly.test.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.poly.test.R
import com.poly.test.databinding.ActivityLoginBinding
import com.poly.test.databinding.ActivitySignupBinding
import com.poly.test.utils.toast
import com.poly.test.viewModel.SignupViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var viewModel: SignupViewModel
    lateinit var bindingLogin: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bindingLogin = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(SignupViewModel::class.java)
        bindingLogin.loginViewModel = viewModel
        viewModel.singliveData.observe(this, Observer {
             when(it){
                 SignupViewModel.SIGNUP_FAILURE -> showErr()
                 SignupViewModel.SIGNUP_SUCCESS->goToHome()
             }

        })
    }
    private fun showErr() {
        toast(viewModel.message)
    }

    private fun goToHome(){
        startActivity(Intent(this, MainActivity::class.java))

    }
}