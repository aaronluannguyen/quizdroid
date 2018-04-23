package edu.wahingoton.nguyen51.quizdroid.Controller

import edu.wahingoton.nguyen51.quizdroid.Model.TopicStruct
import edu.wahingoton.nguyen51.quizdroid.Model.getTopicStruct

const val math = "math"
const val physics = "physics"
const val marvel = "marvel"

fun getTopic(name: String): TopicStruct {
    when (name) {
        math -> return getTopicStruct(math)
        physics -> return getTopicStruct(physics)
        marvel -> return getTopicStruct(marvel)
    }
    return null!!
}