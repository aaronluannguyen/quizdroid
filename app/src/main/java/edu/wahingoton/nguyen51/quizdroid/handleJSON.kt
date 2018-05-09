package edu.wahingoton.nguyen51.quizdroid

import java.io.Serializable

data class JsonQuizzes (
    val quizzes: Array<JsonQuiz>?
)

data class JsonQuiz (
    val title: String?,
    val desc: String?,
    val questions: List<JsonQuestion>?
): Serializable

data class JsonQuestion (
    val question: String?,
    val correctAnswer: Int?,
    val answers: Array<String>?
): Serializable