package edu.wahingoton.nguyen51.quizdroid.Controller

import android.widget.RadioButton
import edu.wahingoton.nguyen51.quizdroid.Model.TopicStruct
import edu.wahingoton.nguyen51.quizdroid.TopicRepository

fun handleAnswerSubmit(c1: RadioButton, c2: RadioButton, c3: RadioButton, c4: RadioButton): String {
    if (c1.isChecked) {
        return c1.text.toString()
    }

    if (c2.isChecked) {
        return c2.text.toString()
    }

    if (c3.isChecked) {
        return c3.text.toString()
    }

    if (c4.isChecked) {
        return c4.text.toString()
    }
    return ""
}

fun updateCorrectCount(topic: TopicRepository.Quiz, correct: String, uAnswer: String) {
    if (correct == uAnswer) {
        topic.correct++
    }
}