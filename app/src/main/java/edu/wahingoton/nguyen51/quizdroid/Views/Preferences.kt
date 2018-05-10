package edu.wahingoton.nguyen51.quizdroid.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import edu.wahingoton.nguyen51.quizdroid.R
import kotlinx.android.synthetic.main.app_bar.*

class Preferences : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        setSupportActionBar(AppBar)
    }
}
