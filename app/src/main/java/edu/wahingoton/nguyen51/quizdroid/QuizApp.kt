package edu.wahingoton.nguyen51.quizdroid

import android.app.Application
import android.util.Log
import edu.wahingoton.nguyen51.quizdroid.Controller.marvel
import edu.wahingoton.nguyen51.quizdroid.Controller.math
import edu.wahingoton.nguyen51.quizdroid.Controller.physics

object QuizApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("QuizApp Status", "QuizApp loaded and running...")
    }

    fun getQuiz(name: String): TopicRepository.Quiz {
        return TopicRepository.getQuizFromRepo(name)
    }
}