package com.poly.test.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.poly.test.R
import com.poly.test.adapter.QuizAdapter
import com.poly.test.data.local.Quiz
import com.poly.test.viewModel.GradeOneViewModel
import kotlinx.android.synthetic.main.activity_grade_one.*
import kotlinx.android.synthetic.main.row_question.*

class GradeOneActivity : AppCompatActivity() {

    lateinit var viewmdel: GradeOneViewModel
    lateinit var quizAdapter: QuizAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade_one)
        setTitle("hello!")
        viewmdel = ViewModelProvider(this).get(GradeOneViewModel::class.java)
        viewmdel.getallQuestionObserver().observe(this, Observer {
            quizAdapter.setUserAdapter(ArrayList(it))
            quizAdapter.notifyDataSetChanged()


        })


        recycle_quiz.apply {
            layoutManager = LinearLayoutManager(this@GradeOneActivity)
            quizAdapter = QuizAdapter()
            adapter = quizAdapter
        }
    }
}