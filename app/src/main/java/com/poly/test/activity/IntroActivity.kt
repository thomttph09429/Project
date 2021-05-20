package com.poly.test.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.viewpager2.widget.ViewPager2
import com.poly.test.R
import com.poly.test.adapter.IntroSlideAdapter
import kotlinx.android.synthetic.main.activity_intro.*


class IntroActivity : AppCompatActivity() {
    lateinit var introslide: IntroSlideAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.hide()

        introslide = IntroSlideAdapter(
            listOf(
                IntroSlide("hello", R.drawable.intro_slide_one),
                IntroSlide("hello", R.drawable.intro_slide_three),
                IntroSlide("hello", R.drawable.intro_slide_two),
            )
        )
        view_pager.adapter = introslide
        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }


        })
        btn_next.setOnClickListener {
            if (view_pager.currentItem + 1 < introslide.itemCount) {
                view_pager.currentItem += 1
            }else{
                startActivity(Intent(this, SignupActivity::class.java))


            }
        }

    }
    }


