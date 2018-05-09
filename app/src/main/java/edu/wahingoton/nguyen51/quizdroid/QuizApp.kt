package edu.wahingoton.nguyen51.quizdroid

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import com.google.gson.Gson
import edu.wahingoton.nguyen51.quizdroid.Views.MainActivity
import java.io.File

class QuizApp: Application() {
    companion object {
        var quizzes = arrayOf<JsonQuiz>()
    }
    override fun onCreate() {
        super.onCreate()
        Log.i("QuizApp Status", "QuizApp loaded and running...")
        getQuizzes(applicationContext)
    }

    fun getQuizzes(context: Context) {
        var file = File("./sdcard/questions.json")
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity(), arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }

        val gson = Gson()
        val quizzes: Array<JsonQuiz> = gson.fromJson(file.reader(), Array<JsonQuiz>::class.java)
        QuizApp.quizzes = quizzes
    }
}