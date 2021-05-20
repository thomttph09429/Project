package com.poly.test.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.poly.test.R
import com.poly.test.activity.GradeOneActivity
import com.poly.test.databinding.FragmentHomeBinding
import com.poly.test.viewModel.HomeViewModel


class HomeFragment : Fragment() {
    lateinit var viewMoDel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        viewMoDel = ViewModelProvider(this).get(HomeViewModel::class.java)
        var binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.homeViewModel = viewMoDel
        var view: View = binding.root

        viewMoDel.uiEventLiveData.observe(this, Observer {
            when (it) {
                HomeViewModel.LOGIN_GRATE_1 -> moToGrateOne()
                HomeViewModel.LOGIN_GRATE_2 -> moToGrateTwo()
                HomeViewModel.LOGIN_GRATE_3 -> moToGrateThree()

            }
        })
        return view
    }

    private fun moToGrateOne() {
        var inten = Intent(context, GradeOneActivity::class.java)
        startActivity(inten)


    }

    private fun moToGrateTwo() {
        var inten = Intent(context, GradeOneActivity::class.java)
        startActivity(inten)

    }

    private fun moToGrateThree() {
        var inten = Intent(context, GradeOneActivity::class.java)
        startActivity(inten)

    }
}