package edu.wahingoton.nguyen51.quizdroid

import java.io.Serializable

interface TopicRepository {
    data class Quiz (
            val title: String,
            val shortDescription: String,
            val longDescription: String,
            val questionCount: Int,
            val questions: List<Question>
    ) : Serializable {
        var correct: Int = 0
        var qIndex: Int = 0
    }

    data class Question (
            val question: String,
            val correctAnswer: String,
            val choice1: String,
            val choice2: String,
            val choice3: String,
            val choice4: String
    ) : Serializable

    val MathQuiz: Quiz
        get() = Quiz(
                "Math",
        "Quiz with numbers!",
        "Welcome! Get ready to test some of your math skills with basic arithmetic.",
        4,
            listOf(
                    Question(
                            "What does 2 + 2 = ?",
                            "4",
                            "3",
                            "Fish",
                            "4",
                            "22"
                    ),
                    Question(
                            "What does 10 - 7 = ?",
                            "3",
                            "107",
                            "2",
                            "17",
                            "3"
                    ),
                    Question(
                            "What does 4 * 6 = ?",
                            "24",
                            "24",
                            "64",
                            "40",
                            "16"
                    ),
                    Question(
                            "What does 64 / 8 = ?",
                            "8",
                            "7",
                            "8",
                            "6",
                            "9"
                    )
            )
        )

    val PhysicsQuiz: Quiz
        get() = Quiz(
            "Physics",
            "Quiz on physic subjects!",
            "Welcome! Get ready to test some of your physics knowledge!",
            4,
            listOf(
                    Question(
                            "A light year is a unit of what?",
                            "Distance",
                            "Time",
                            "Distance",
                            "Light",
                            "Intensity of Light"
                    ),
                    Question(
                            "Light from the Sun reaches Earth in nearly how many minutes?",
                            "8 minutes",
                            "2 minutes",
                            "4 minutes",
                            "8 minutes",
                            "16 minutes"
                    ),
                    Question(
                            "Stars appears to move from east to west because...",
                            "The Earth rotates from west to east",
                            "All stars move from east to west",
                            "The Earth rotates from west to east",
                            "The Eart rotates from east to west",
                            "The background of the stars moves from west to east"
                    ),
                    Question(
                            "Planets do not twinkle because...",
                            "They are nearer to earth and hence we receive a greater amount of light and, therefore minor variations in the intensity are not noticeable",
                            "They emit light of a constant intensity",
                            "Their distance from the Earth does not change with time",
                            "They are very far away from the Earth resulting in decrease in intensity of light",
                            "They are nearer to earth and hence we receive a greater amount of light and, therefore minor variations in the intensity are not noticeable"
                    )
            )
        )

    val MarvelQuiz: Quiz
        get() = Quiz(
                "Marvel Super Heroes",
                "Marvel Universe questions!",
                "Welcome! Who doesn't love superheroes? It is time to test what you know about the heroes in the Marvel Universe.",
                4,
                listOf(
                        Question(
                                "Who is Iron Man's alter ego?",
                                "Tony Stark",
                                "Steve Rogers",
                                "Bruce Banner",
                                "Tony Stark",
                                "Clint Barton"
                        ),
                        Question(
                                "Who is the villain most commonly associated with the Infinity Gauntlet?",
                                "Thanos",
                                "Ultron",
                                "Thanos",
                                "Loki",
                                "Hydra"
                        ),
                        Question(
                                "The first civil war is between which two people?",
                                "Iron Man & Captain America",
                                "Hawkeye & Black Widow",
                                "Thor & Hulk",
                                "War Machine & Falcon",
                                "Iron Man & Captain America"
                        ),
                        Question(
                                "Which is not an Infinity Stone?",
                                "Brain Stone",
                                "Time Stone",
                                "Space Stone",
                                "Brain Stone",
                                "Power Stone"
                        )
                )
        )
}