package com.poly.test.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.poly.test.R


class GradeOneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        var view = inflater.inflate(R.layout.fragment_grade_one, container, false)

        return view

    }


}