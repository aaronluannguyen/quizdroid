package edu.wahingoton.nguyen51.quizdroid

import android.app.Application
import android.util.Log
import edu.wahingoton.nguyen51.quizdroid.Controller.marvel
import edu.wahingoton.nguyen51.quizdroid.Controller.math
import edu.wahingoton.nguyen51.quizdroid.Controller.physics

class QuizApp : Application() {
    companion object {
        val MathQuiz = TopicRepository.MathQuiz
        val PhysicsQuiz = TopicRepository.PhysicsQuiz
        val MarvelQuiz = TopicRepository.MarvelQuiz
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("QuizApp Status", "QuizApp loaded and running...")
    }

    // Might not need this function
    fun getQuiz(name: String): TopicRepository.Quiz {
        when (name) {
            math -> return TopicRepository.MathQuiz
            physics -> return TopicRepository.PhysicsQuiz
            marvel -> return TopicRepository.MarvelQuiz
        }
        return null!!
    }
}