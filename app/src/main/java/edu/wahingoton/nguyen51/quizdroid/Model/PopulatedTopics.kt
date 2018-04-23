package edu.wahingoton.nguyen51.quizdroid.Model

import edu.wahingoton.nguyen51.quizdroid.Controller.marvel
import edu.wahingoton.nguyen51.quizdroid.Controller.math
import edu.wahingoton.nguyen51.quizdroid.Controller.physics

val MathTopic = TopicStruct(
    "Math",
    "Welcome! Get ready to test some of your math skills with basic arithmetic.",
    4,
    getMathTopic()
)

val PhysicsTopic = TopicStruct(
    "Physics",
    "Welcome! Get ready to test some of your physics knowledge!",
    4,
    getPhysicsTopic()
)

val MarvelTopic = TopicStruct(
    "Marvel Super Heroes",
    "Welcome! Who doesn't love superheroes? It is time to test what you know about the heroes in the Marvel Universe.",
    4,
    getMarvelTopic()
)

fun getMathTopic(): List<QuestionStruct> {
    val q1 = QuestionStruct(
        "What does 2 + 2 = ?",
        "4",
        "3",
        "Fish",
        "4",
        "22"
    )

    val q2 = QuestionStruct(
        "What does 10 - 7 = ?",
        "3",
        "107",
        "2",
        "17",
        "3"
    )

    val q3 = QuestionStruct(
        "What does 4 * 6 = ?",
        "24",
        "24",
        "64",
        "40",
        "16"
    )

    val q4 = QuestionStruct(
        "What does 64 / 8 = ?",
        "8",
        "7",
        "8",
        "6",
        "9"
    )

    return listOf(q1, q2, q3, q4)
}

fun getPhysicsTopic(): List<QuestionStruct> {
    val q1 = QuestionStruct(
        "A light year is a unit of what?",
        "Distance",
        "Time",
        "Distance",
        "Light",
        "Intensity of Light"
    )

    val q2 = QuestionStruct(
        "Light from the Sun reaches Earth in nearly how many minutes?",
        "8 minutes",
        "2 minutes",
        "4 minutes",
        "8 minutes",
        "16 minutes"
    )

    val q3 = QuestionStruct(
        "Stars appears to move from east to west because...",
        "The Earth rotates from west to east",
        "All stars move from east to west",
        "The Earth rotates from west to east",
        "The Eart rotates from east to west",
        "The background of the stars moves from west to east"
    )

    val q4 = QuestionStruct(
        "Planets do not twinkle because...",
        "They are nearer to earth and hence we receive a greater amount of light and, therefore minor variations in the intensity are not noticeable",
        "They emit light of a constant intensity",
        "Their distance from the Earth does not change with time",
        "They are very far away from the Earth resulting in decrease in intensity of light",
        "They are nearer to earth and hence we receive a greater amount of light and, therefore minor variations in the intensity are not noticeable"
    )

    return listOf(q1, q2, q3, q4)
}

fun getMarvelTopic(): List<QuestionStruct> {
    val q1 = QuestionStruct(
        "Who is Iron Man's alter ego?",
        "Tony Stark",
        "Steve Rogers",
        "Bruce Banner",
        "Tony Stark",
        "Clint Barton"
    )

    val q2 = QuestionStruct(
        "Who is the villain most commonly associated with the Infinity Gauntlet?",
        "Thanos",
        "Ultron",
        "Thanos",
        "Loki",
        "Hydra"
    )

    val q3 = QuestionStruct(
        "The first civil war is between which two people?",
        "Iron Man & Captain America",
        "Hawkeye & Black Widow",
        "Thor & Hulk",
        "War Machine & Falcon",
        "Iron Man & Captain America"
    )

    val q4 = QuestionStruct(
        "Which is not an Infinity Stone?",
        "Brain Stone",
        "Time Stone",
        "Space Stone",
        "Brain Stone",
        "Power Stone"
    )

    return listOf(q1, q2, q3, q4)
}