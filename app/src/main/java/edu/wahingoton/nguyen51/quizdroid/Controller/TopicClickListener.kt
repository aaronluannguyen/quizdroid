package edu.wahingoton.nguyen51.quizdroid.Controller

const val math = "math"
const val physics = "physics"
const val marvel = "marvel"

fun getTopic(name: String): String {
    when (name) {
        math -> return math
        physics -> return physics
        marvel -> return marvel
    }
    return ""
}

fun handleTopicSelect(name: String) {
    val topic = getTopic(name)
    if (!topic.isEmpty()) {

    }
}

