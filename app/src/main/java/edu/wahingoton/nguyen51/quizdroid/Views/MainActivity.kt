package edu.wahingoton.nguyen51.quizdroid.Views

import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import com.google.gson.Gson
import edu.wahingoton.nguyen51.quizdroid.JsonQuiz
import edu.wahingoton.nguyen51.quizdroid.QuizApp
import edu.wahingoton.nguyen51.quizdroid.R
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMainView()

        MathCard.setOnClickListener {
            val intent = Intent(this, QuizFragmentsActivity::class.java).apply {
                putExtra("topic", QuizApp.MathQuiz)
            }
            startActivity(intent)
        }

        PhysicsCard.setOnClickListener {
            val intent = Intent(this, QuizFragmentsActivity::class.java).apply {
                putExtra("topic", QuizApp.PhysicsQuiz)
            }
            startActivity(intent)
        }
        MarvelCard.setOnClickListener {
            val intent = Intent(this, QuizFragmentsActivity::class.java).apply {
                putExtra("topic", QuizApp.MarvelQuiz)
            }
            startActivity(intent)
        }
    }

    fun setMainView() {
        MathTitle.setText(QuizApp.MathQuiz.title)
        MathShortDesc.setText(QuizApp.MathQuiz.shortDescription)

        PhysicsTitle.setText(QuizApp.PhysicsQuiz.title)
        PhysicsShortDesc.setText(QuizApp.PhysicsQuiz.shortDescription)

        MarvelTitle.setText(QuizApp.MarvelQuiz.title)
        MarvelShortDesc.setText(QuizApp.MarvelQuiz.shortDescription)
    }
}
