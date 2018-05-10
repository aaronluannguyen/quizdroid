package edu.wahingoton.nguyen51.quizdroid.Views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import edu.wahingoton.nguyen51.quizdroid.JsonQuiz
import edu.wahingoton.nguyen51.quizdroid.R
import edu.wahingoton.nguyen51.quizdroid.TopicRepository


class QuizFragmentsActivity : AppCompatActivity(), TopicOverview.OnFragmentInteractionListener, Question.OnFragmentInteractionListener, Answer.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_fragments)

        val topic: JsonQuiz = intent.getSerializableExtra("topic") as JsonQuiz
        val topicBundle = Bundle()
        topicBundle.putSerializable("topic", topic)
        val topicOverviewFrag = TopicOverview()
        topicOverviewFrag.arguments = topicBundle
        fragmentManager.beginTransaction()
                .add(R.id.quiz_fragments_activity, topicOverviewFrag)
                .addToBackStack(null)
                .commit()
    }

    override fun startQuizFrag(topic: JsonQuiz?) {
        val topicBundle = Bundle()
        topicBundle.putSerializable("topic", topic)
        val questionFrag = Question()
        questionFrag.arguments = topicBundle
        fragmentManager.beginTransaction()
                .replace(R.id.quiz_fragments_activity, questionFrag)
                .addToBackStack(null)
                .commit()
    }

    override fun toAnswerFragment(topic: JsonQuiz?, answer: Int) {
        val topicBundle = Bundle()
        topicBundle.putSerializable("topic", topic)
        topicBundle.putInt("answer", answer)
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