package com.poly.test.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.poly.test.utils.SingleLiveData

class HomeViewModel : ViewModel() {
    companion object {
        const val LOGIN_GRATE_1 = 1
        const val LOGIN_GRATE_2= 2
        const val LOGIN_GRATE_3 = 3
    }

    val uiEventLiveData = SingleLiveData<Int>()

    fun clickDoGrateOne() {
        uiEventLiveData.value = LOGIN_GRATE_1

    }

    fun clickDoGrateTwo() {
        uiEventLiveData.value = LOGIN_GRATE_2

    }

    fun clickDoGrateThree() {
        uiEventLiveData.value = LOGIN_GRATE_3

    }
}