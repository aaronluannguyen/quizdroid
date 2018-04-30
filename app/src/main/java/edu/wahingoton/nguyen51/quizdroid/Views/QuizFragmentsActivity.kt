package edu.wahingoton.nguyen51.quizdroid.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import edu.wahingoton.nguyen51.quizdroid.Model.TopicStruct
import edu.wahingoton.nguyen51.quizdroid.R


class QuizFragmentsActivity : AppCompatActivity(), TopicOverview.OnFragmentInteractionListener {

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
}