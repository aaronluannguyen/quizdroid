package edu.wahingoton.nguyen51.quizdroid.Views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import edu.wahingoton.nguyen51.quizdroid.Controller.*
import edu.wahingoton.nguyen51.quizdroid.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MathCard.setOnClickListener {
            val intent = Intent(this, QuizFragmentsActivity::class.java).apply {
                putExtra("topic", getTopic(math))
            }
            startActivity(intent)
        }

        PhysicsCard.setOnClickListener {
            val intent = Intent(this, QuizFragmentsActivity::class.java).apply {
                putExtra("topic", getTopic(physics))
            }
            startActivity(intent)
        }
        MarvelCard.setOnClickListener {
            val intent = Intent(this, QuizFragmentsActivity::class.java).apply {
                putExtra("topic", getTopic(marvel))
            }
            startActivity(intent)
        }
    }
}
