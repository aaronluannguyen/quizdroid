package edu.wahingoton.nguyen51.quizdroid

import android.app.Application
import android.util.Log

class QuizApp: Application() {
    companion object {
        var quizzes = arrayOf<JsonQuiz>()
    }
    override fun onCreate() {
        super.onCreate()
        Log.i("QuizApp Status", "QuizApp loaded and running...")
    }
}