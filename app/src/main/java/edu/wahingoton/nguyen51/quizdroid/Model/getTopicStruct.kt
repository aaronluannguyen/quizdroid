package edu.wahingoton.nguyen51.quizdroid.Model

import edu.wahingoton.nguyen51.quizdroid.Controller.marvel
import edu.wahingoton.nguyen51.quizdroid.Controller.math
import edu.wahingoton.nguyen51.quizdroid.Controller.physics

fun getTopicStruct(name: String): TopicStruct {
    when (name) {
        math -> return MathTopic
        physics -> return PhysicsTopic
        marvel -> return MarvelTopic
    }
    return null!!
}