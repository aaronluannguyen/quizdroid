package edu.wahingoton.nguyen51.quizdroid.Controller

import android.widget.RadioButton
import edu.wahingoton.nguyen51.quizdroid.JsonQuiz

fun handleAnswerSubmit(c1: RadioButton, c2: RadioButton, c3: RadioButton, c4: RadioButton): Int {
    if (c1.isChecked) {
        return 1
    }

    if (c2.isChecked) {
        return 2
    }

    if (c3.isChecked) {
        return 3
    }

    if (c4.isChecked) {
        return 4
    }
    return 0
}

fun updateCorrectCount(topic: JsonQuiz, correct: Int?, uAnswer: Int) {
    if (correct == uAnswer) {
        topic.correct++
    }
}