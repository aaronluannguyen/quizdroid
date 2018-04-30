package edu.wahingoton.nguyen51.quizdroid.Model

import java.io.Serializable

data class QuestionStruct (
    val question: String,
    val correctAnswer: String,
    val choice1: String,
    val choice2: String,
    val choice3: String,
    val choice4: String
) : Serializable