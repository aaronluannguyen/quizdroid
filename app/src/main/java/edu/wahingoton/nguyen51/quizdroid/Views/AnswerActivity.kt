package edu.wahingoton.nguyen51.quizdroid.Views
import android.content.Intent
import edu.wahingoton.nguyen51.quizdroid.R

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import edu.wahingoton.nguyen51.quizdroid.Controller.updateCorrectCount
import edu.wahingoton.nguyen51.quizdroid.JsonQuiz
import kotlinx.android.synthetic.main.activity_answer.*
import kotlinx.android.synthetic.main.app_bar.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        setSupportActionBar(AppBar)
        preferencesIcon.setOnClickListener{
            val intent = Intent(this, Preferences::class.java)
            startActivity(intent)
        } 

        var topic: JsonQuiz = intent.getSerializableExtra("topic") as JsonQuiz
        var userAnswer = intent.getIntExtra("answer", 0)

        setAnswerScreen(topic, userAnswer)

        btnNextFinish.setOnClickListener {
            val intent: Intent
            if (btnNextFinish.text == "Next") {
                topic.qIndex++
                intent = Intent(this, QuizActivity::class.java).apply {
                    putExtra("topic", topic)
                }
            } else {
                intent = Intent(this, MainActivity::class.java)
            }
            startActivity(intent)
        }
    }

    fun setAnswerScreen(topic: JsonQuiz, uAnswer: Int) {
        var correctAnswer = topic.questions?.get(topic.qIndex)?.answer
        CorrectAnswer.setText("Correct Answer: " + correctAnswer)
        UserAnswer.setText("Your Answer: " + uAnswer)

        updateCorrectCount(topic, correctAnswer, uAnswer)

        CorrectVsTotal.setText("You have " + topic.correct.toString() + " out of " + (topic.qIndex + 1).toString() + " correct!")

        if (topic.qIndex == topic.questions?.size?.minus(1)) {
            btnNextFinish.setText("Finish")
        }
    }
}
