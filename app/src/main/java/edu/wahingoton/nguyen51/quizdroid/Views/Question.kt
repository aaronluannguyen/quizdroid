package edu.wahingoton.nguyen51.quizdroid.Views

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.wahingoton.nguyen51.quizdroid.Controller.handleAnswerSubmit
import edu.wahingoton.nguyen51.quizdroid.Model.TopicStruct

import edu.wahingoton.nguyen51.quizdroid.R
import kotlinx.android.synthetic.main.activity_quiz.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Question.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Question.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Question : Fragment() {
    // TODO: Rename and change types of parameters
    private var topic: TopicStruct? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            topic = it.getSerializable("topic") as TopicStruct
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_quiz, container, false)
    }

    override fun onStart() {
        super.onStart()
        val question = this.topic?.questions
        val curr = this.topic?.qIndex
        Question.setText(question?.get(topic?.qIndex as Int)?.question)
        choice1.setText(question?.get(curr as Int)?.choice1)
        choice2.setText(question?.get(curr as Int)?.choice2)
        choice3.setText(question?.get(curr as Int)?.choice3)
        choice4.setText(question?.get(curr as Int)?.choice4)

        btnSubmit.setOnClickListener {
            val answer = handleAnswerSubmit(choice1,choice2, choice3, choice4)
            listener?.toAnswerFragment(this.topic, answer)
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
        fun toAnswerFragment(topic: TopicStruct?, answer: String)
    }
}
