package edu.wahingoton.nguyen51.quizdroid.Views

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.wahingoton.nguyen51.quizdroid.Controller.updateCorrectCount
import edu.wahingoton.nguyen51.quizdroid.JsonQuiz
import edu.wahingoton.nguyen51.quizdroid.R
import kotlinx.android.synthetic.main.activity_answer.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Answer.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Answer.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Answer : Fragment() {
    // TODO: Rename and change types of parameters
    private var topic: JsonQuiz? = null
    private var uAnswer: Int? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            topic = it.getSerializable("topic") as JsonQuiz
            uAnswer = it.getInt("answer")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_answer, container, false)
    }

    override fun onStart() {
        super.onStart()
        var curr: Int = this.topic?.qIndex as Int
        var currQuestion = this.topic?.questions?.get(curr)
        var correctAnswer = currQuestion?.answers?.get(currQuestion?.answer?.minus(1) as Int)
        var correctAnswerInt = uAnswer?.minus(1)
        CorrectAnswer.setText("Correct Answer: " + correctAnswer)
        UserAnswer.setText("Your Answer: " + currQuestion?.answers?.get(correctAnswerInt as Int))

        updateCorrectCount(topic as JsonQuiz, correctAnswerInt?.plus(1), uAnswer as Int)

        CorrectVsTotal.setText("You have " + topic?.correct.toString() + " out of " + (topic?.qIndex as Int + 1).toString() + " correct!")

        if (topic?.qIndex == topic?.questions?.size as Int - 1) {
            btnNextFinish.setText("Finish")
        }

        btnNextFinish.setOnClickListener {
            if (btnNextFinish.text == "Next") {
                this.topic?.qIndex = this.topic?.qIndex as Int + 1
                listener?.startQuizFrag(this.topic)
            } else {
                listener?.finishQuiz()
            }
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
        fun startQuizFrag(topic: JsonQuiz?)
        fun finishQuiz()
    }
}
