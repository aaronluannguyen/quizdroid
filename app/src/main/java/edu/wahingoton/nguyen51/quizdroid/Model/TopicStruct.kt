package edu.wahingoton.nguyen51.quizdroid.Model

import java.io.Serializable

data class TopicStruct (
    val name: String,
    val description: String,
    val questionCount: Int,
    val questions: List<QuestionStruct>,
    val correct: Int,
    val qIndex: Int
) : Serializable