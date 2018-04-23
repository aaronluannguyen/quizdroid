package edu.wahingoton.nguyen51.quizdroid.Views
import android.content.Intent
import edu.wahingoton.nguyen51.quizdroid.R

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import edu.wahingoton.nguyen51.quizdroid.Model.TopicStruct
import kotlinx.android.synthetic.main.activity_introduction.*

class IntroductionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        val topic: TopicStruct = intent.getSerializableExtra("topic") as TopicStruct

        setIntroScreen(topic)

        btnBegin.setOnClickListener{
            val intent = Intent(this, QuizActivity::class.java).apply {
                putExtra("topic", topic)
            }
            startActivity(intent)
        }
    }

    fun setIntroScreen(topic: TopicStruct) {
        IntroTopic.setText("Quiz Topic: " + topic.name)
        IntroDesc.setText(topic.description)
        IntroQTotal.setText("Total Number of Questions: " + topic.questionCount.toString())
    }
}
