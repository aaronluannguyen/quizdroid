package edu.wahingoton.nguyen51.quizdroid.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import edu.wahingoton.nguyen51.quizdroid.QuizApp
import edu.wahingoton.nguyen51.quizdroid.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quizzes = QuizApp.quizzes
        val formatQuiz = arrayOfNulls<String?>(quizzes.size)
        for (i in quizzes.indices) {
            formatQuiz[i] = quizzes[i].title
        }
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, formatQuiz)
        QuizList.adapter = adapter
    }
}
