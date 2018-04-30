package edu.wahingoton.nguyen51.quizdroid.Views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import edu.wahingoton.nguyen51.quizdroid.Controller.getTopic
import edu.wahingoton.nguyen51.quizdroid.Controller.physics
import edu.wahingoton.nguyen51.quizdroid.Model.TopicStruct
import edu.wahingoton.nguyen51.quizdroid.R


class QuizFragmentsActivity : AppCompatActivity(), TopicOverview.OnFragmentInteractionListener, Question.OnFragmentInteractionListener, Answer.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_fragments)

        val topic: TopicStruct = intent.getSerializableExtra("topic") as TopicStruct
        val topicBundle = Bundle()
        topicBundle.putSerializable("topic", topic)
        val topicOverviewFrag = TopicOverview()
        topicOverviewFrag.arguments = topicBundle
        fragmentManager.beginTransaction()
                .add(R.id.quiz_fragments_activity, topicOverviewFrag)
                .addToBackStack(null)
                .commit()
    }

    override fun startQuizFrag(topic: TopicStruct?) {
        val topicBundle = Bundle()
        topicBundle.putSerializable("topic", topic)
        val questionFrag = Question()
        questionFrag.arguments = topicBundle
        fragmentManager.beginTransaction()
                .replace(R.id.quiz_fragments_activity, questionFrag)
                .addToBackStack(null)
                .commit()
    }

    override fun toAnswerFragment(topic: TopicStruct?, answer: String) {
        val topicBundle = Bundle()
        topicBundle.putSerializable("topic", topic)
        topicBundle.putString("answer", answer)
        val answerFrag = Answer()
        answerFrag.arguments = topicBundle
        fragmentManager.beginTransaction()
                .replace(R.id.quiz_fragments_activity, answerFrag)
                .addToBackStack(null)
                .commit()
    }

    override fun finishQuiz() {
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)
    }
}