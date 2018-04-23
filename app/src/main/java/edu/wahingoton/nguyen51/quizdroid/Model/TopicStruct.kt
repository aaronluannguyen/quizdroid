package edu.wahingoton.nguyen51.quizdroid.Model

data class TopicStruct (
    val name: String,
    val description: String,
    val questionCount: Int,
    val questions: List<QuestionStruct>
)