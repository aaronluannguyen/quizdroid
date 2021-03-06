package edu.wahingoton.nguyen51.quizdroid.Views

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.wahingoton.nguyen51.quizdroid.Controller.handleAnswerSubmit
import edu.wahingoton.nguyen51.quizdroid.JsonQuiz
import edu.wahingoton.nguyen51.quizdroid.R
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.app_bar.*

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
    private var topic: JsonQuiz? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            topic = it.getSerializable("topic") as JsonQuiz
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_quiz, container, false)
    }

    override fun onStart() {
        super.onStart()
        val questions = this.topic?.questions
        val curr = this.topic?.qIndex
        val question = questions?.get(curr as Int)
        btnSubmit.isClickable = false
        Question.setText(question?.text)
        choice1.setText(question?.answers?.get(0))
        choice2.setText(question?.answers?.get(1))
        choice3.setText(question?.answers?.get(2))
        choice4.setText(question?.answers?.get(3))

        btnSubmit.setOnClickListener {
            val answer = handleAnswerSubmit(choice1,choice2, choice3, choice4)
            if (answer != 0) {
                btnSubmit.isClickable = true
                listener?.toAnswerFragment(this.topic, answer)
            }
        }
        preferencesIcon.setOnClickListener{
            listener?.toPreferences()
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
        fun toAnswerFragment(topic: JsonQuiz?, answer: Int)
        fun toPreferences()
    }
}
