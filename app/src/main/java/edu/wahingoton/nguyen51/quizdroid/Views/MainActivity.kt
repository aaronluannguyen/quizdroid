package edu.wahingoton.nguyen51.quizdroid.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import edu.wahingoton.nguyen51.quizdroid.Controller.*
import edu.wahingoton.nguyen51.quizdroid.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MathCard.setOnClickListener { handleTopicSelect(math) }
        PhysicsCard.setOnClickListener { handleTopicSelect(physics) }
        MarvelCard.setOnClickListener { handleTopicSelect(marvel) }
    }
}
