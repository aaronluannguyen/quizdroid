package edu.wahingoton.nguyen51.quizdroid.Views

import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.google.gson.Gson
import edu.wahingoton.nguyen51.quizdroid.JsonQuiz
import edu.wahingoton.nguyen51.quizdroid.QuizApp
import edu.wahingoton.nguyen51.quizdroid.QuizItemAdapter
import edu.wahingoton.nguyen51.quizdroid.R
import edu.wahingoton.nguyen51.quizdroid.R.id.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(AppBar)
        preferencesIcon.setOnClickListener{
            val intent = Intent(this, Preferences::class.java)
            startActivity(intent)
        }

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            getPermission()
        } else {
            startMain()
        }

    }

    fun getPermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        startMain()
    }

    fun startMain() {
        var file = File("./sdcard/questions.json")
        val gson = Gson()
        val quizzes: Array<JsonQuiz> = gson.fromJson(file.reader(), Array<JsonQuiz>::class.java)
        QuizApp.quizzes = quizzes
        val formatQuiz = arrayOfNulls<String?>(QuizApp.quizzes.size)
        for (i in QuizApp.quizzes.indices) {
            formatQuiz[i] = QuizApp.quizzes[i].title
        }
        val adapter = QuizItemAdapter(this, QuizApp.quizzes)
        QuizList.adapter = adapter

        QuizList.setOnItemClickListener {_, _, position, _ ->
            val quiz = QuizApp.quizzes[position]
            val intent = Intent(this, QuizFragmentsActivity::class.java).apply {
                putExtra("topic", quiz)
            }
            startActivity(intent)
        }
    }
}
