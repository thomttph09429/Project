package com.poly.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poly.test.R
import com.poly.test.data.local.Quiz
import kotlinx.android.synthetic.main.row_question.view.*
class QuizAdapter : RecyclerView.Adapter<QuizAdapter.UserViewholder>() {

    var listquiz = ArrayList<Quiz>()
    fun setUserAdapter(data: ArrayList<Quiz>) {
        this.listquiz = data
    }


    class UserViewholder(view: View) : RecyclerView.ViewHolder(view) {
        val tvquestion = view.tv_question
        val tvoption1 = view.tv_option1
        val tvoption2 = view.tv_option2
        val tvoption3 = view.tv_option3
        val tvoption4 = view.tv_option4

        fun bind(quiz: Quiz) {
            tvquestion.text = quiz.question
            tvoption1.text = quiz.option1
            tvoption2.text = quiz.option2
            tvoption3.text = quiz.option3
            tvoption4.text = quiz.option4

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewholder {
        var holder = LayoutInflater.from(parent.context).inflate(R.layout.row_question, parent, false)
        return UserViewholder(holder)
    }

    override fun onBindViewHolder(holder: UserViewholder, position: Int) {
        return holder.bind(listquiz[position])
    }

    override fun getItemCount(): Int {
        return listquiz.size

    }


}