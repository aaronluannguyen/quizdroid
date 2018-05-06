package edu.wahingoton.nguyen51.quizdroid.Views

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.wahingoton.nguyen51.quizdroid.Model.TopicStruct

import edu.wahingoton.nguyen51.quizdroid.R
import edu.wahingoton.nguyen51.quizdroid.TopicRepository
import kotlinx.android.synthetic.main.activity_introduction.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TopicOverview.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TopicOverview.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TopicOverview : Fragment() {
    // TODO: Rename and change types of parameters
    private var topic: TopicRepository.Quiz? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            topic = it.getSerializable("topic") as TopicRepository.Quiz
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_introduction, container, false)
    }

    override fun onStart() {
        super.onStart()
        IntroTopic.setText("Quiz Topic: " + this.topic?.title)
        IntroDesc.setText(this.topic?.longDescription)
        IntroQTotal.setText("Total Number of Questions: " + this.topic?.questionCount.toString())
        btnBegin.setOnClickListener{
            listener?.startQuizFrag(this.topic)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun startQuizFrag(topic: TopicRepository.Quiz?)
    }
}
