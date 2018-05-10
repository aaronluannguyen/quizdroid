package edu.wahingoton.nguyen51.quizdroid

import java.io.Serializable

data class JsonQuiz (
    val title: String?,
    val desc: String?,
    val questions: List<JsonQuestion>?
): Serializable {
    var correct: Int = 0
    var qIndex: Int = 0
}

data class JsonQuestion (
    val text: String?,
    val answer: Int?,
    val answers: Array<String>?
): Serializable