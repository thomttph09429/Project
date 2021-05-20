package com.poly.test.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.poly.test.data.local.Quiz
import com.poly.test.data.local.RoomQuizDb

class GradeOneViewModel(app: Application) : AndroidViewModel(app) {


    lateinit var allquestion: MutableLiveData<List<Quiz>>


    init {
        allquestion = MutableLiveData()

    }

    fun getallQuestionObserver(): MutableLiveData<List<Quiz>> {
        return allquestion
    }

    fun getAllQueston() {
        val quizdao = RoomQuizDb.getInstance(getApplication()).getquizDao()
        var list = quizdao.getallQuiz()
        allquestion.value = list
    }


    fun insert(quiz: Quiz) {
        val quizdao = RoomQuizDb.getInstance(getApplication()).getquizDao()
        quizdao.Insert(quiz)



    }





}