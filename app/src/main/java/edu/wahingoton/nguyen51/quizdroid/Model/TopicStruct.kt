package edu.wahingoton.nguyen51.quizdroid.Model

import java.io.Serializable

data class TopicStruct (
    val name: String,
    val description: String,
    val questionCount: Int,
    val questions: List<QuestionStruct>
) : Serializable {
    var correct: Int = 0
    var qIndex: Int = 0
}