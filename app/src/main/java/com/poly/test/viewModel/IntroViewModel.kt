package com.poly.test.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.poly.test.activity.IntroSlide
import com.poly.test.utils.SingleLiveData

class IntroViewModel : ViewModel() {


    internal val nextPage = SingleLiveData<Int>()


}