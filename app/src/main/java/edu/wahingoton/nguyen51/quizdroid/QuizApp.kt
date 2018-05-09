package edu.wahingoton.nguyen51.quizdroid

import android.app.Application
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import com.google.gson.Gson
import edu.wahingoton.nguyen51.quizdroid.Controller.marvel
import edu.wahingoton.nguyen51.quizdroid.Controller.math
import edu.wahingoton.nguyen51.quizdroid.Controller.physics
import edu.wahingoton.nguyen51.quizdroid.Views.MainActivity
import java.io.File

class QuizApp : Application() {
    companion object {
        val MathQuiz = TopicRepository.MathQuiz
        val PhysicsQuiz = TopicRepository.PhysicsQuiz
        val MarvelQuiz = TopicRepository.MarvelQuiz
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("QuizApp Status", "QuizApp loaded and running...")

        var file = File("./sdcard/questions.json")
        if (ContextCompat.checkSelfPermission(applicationContext, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity(), arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }

        val gson = Gson()
        val quizzes: Array<JsonQuiz> = gson.fromJson(file.reader(), Array<JsonQuiz>::class.java)
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