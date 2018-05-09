package edu.wahingoton.nguyen51.quizdroid

import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.google.gson.Gson
import edu.wahingoton.nguyen51.quizdroid.Views.MainActivity
import java.io.File
import java.io.Serializable

data class JsonQuiz (
    val title: String?,
    val desc: String?,
    val questions: List<JsonQuestion>?
): Serializable

data class JsonQuestion (
    val question: String?,
    val correctAnswer: Int?,
    val answers: Array<String>?
): Serializable

fun getQuizzes(): Array<JsonQuiz> {
    var file = File("./sdcard/questions.json")
    if (ContextCompat.checkSelfPermission(android.app.Application().applicationContext, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(MainActivity(), arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
    }

    val gson = Gson()
    val quizzes: Array<JsonQuiz> = gson.fromJson(file.reader(), Array<JsonQuiz>::class.java)
    return quizzes
}