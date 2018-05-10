package edu.wahingoton.nguyen51.quizdroid.Views

import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import edu.wahingoton.nguyen51.quizdroid.JsonQuiz
import edu.wahingoton.nguyen51.quizdroid.QuizApp
import edu.wahingoton.nguyen51.quizdroid.R
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var file = File("./sdcard/questions.json")
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }

        val gson = Gson()
        val quizzes: Array<JsonQuiz> = gson.fromJson(file.reader(), Array<JsonQuiz>::class.java)
        QuizApp.quizzes = quizzes

        val formatQuiz = arrayOfNulls<String?>(quizzes.size)
        for (i in quizzes.indices) {
            formatQuiz[i] = quizzes[i].title
        }
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, formatQuiz)
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
