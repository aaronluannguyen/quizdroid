package edu.wahingoton.nguyen51.quizdroid.Views

import android.content.Intent
import edu.wahingoton.nguyen51.quizdroid.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import edu.wahingoton.nguyen51.quizdroid.Controller.handleAnswerSubmit
import edu.wahingoton.nguyen51.quizdroid.Model.TopicStruct
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.app_bar.*

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        setSupportActionBar(AppBar)
        preferencesIcon.setOnClickListener{
            val intent = Intent(this, Preferences::class.java)
            startActivity(intent)
        }

        val topic: TopicStruct = intent.getSerializableExtra("topic") as TopicStruct

        setQuizScreen(topic)

        btnSubmit.setOnClickListener {
            val answer = handleAnswerSubmit(choice1,choice2, choice3, choice4)

            val intent = Intent(this, AnswerActivity::class.java).apply {
                putExtra("topic", topic)
                putExtra("answer", answer)
            }
            startActivity(intent)
        }
    }

    fun setQuizScreen(topic: TopicStruct) {
        val question = topic.questions
        val curr = topic.qIndex
        Question.setText(question.get(topic.qIndex).question)
        choice1.setText(question.get(curr).choice1)
        choice2.setText(question.get(curr).choice2)
        choice3.setText(question.get(curr).choice3)
        choice4.setText(question.get(curr).choice4)
    }
}
