package edu.wahingoton.nguyen51.quizdroid

import android.app.Application
import android.util.Log

class QuizApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("QuizApp Status", "QuizApp loaded and running...")
    }


}