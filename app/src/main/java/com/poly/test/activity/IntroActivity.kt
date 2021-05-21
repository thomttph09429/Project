package com.poly.test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.poly.test.R
import com.poly.test.adapter.IntroSlideAdapter
import com.poly.test.viewModel.IntroViewModel
import com.poly.test.utils.intent
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.fragment_grade_one.*
import kotlinx.android.synthetic.main.intro_row.*
import kotlinx.android.synthetic.main.fragment_grade_one.viewpager as viewpager1


class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.hide()
        var viewmodel = ViewModelProvider(this).get(IntroViewModel::class.java)

        val adapter = IntroSlideAdapter(viewmodel)
        val items = listOf(
            IntroSlide("hello", R.drawable.intro_slide_one),
            IntroSlide("hello", R.drawable.intro_slide_three),
            IntroSlide("hello", R.drawable.intro_slide_two),
        )
        adapter.replaceItems(items)
        view_pager.adapter = adapter

        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

        })
        viewmodel.nextPage.observe(this, Observer { position ->
          view_pager.setCurrentItem(position, true)
            if (position ==2)
                intent()


        })


    }
}


