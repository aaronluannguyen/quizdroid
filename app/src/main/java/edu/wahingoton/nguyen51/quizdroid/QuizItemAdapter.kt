package edu.wahingoton.nguyen51.quizdroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item_quiz.view.*

class QuizItemAdapter (
    private val context: Context,
    private val dataSource: Array<JsonQuiz>
): BaseAdapter() {
    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_quiz, parent, false)

        val quiz = getItem(position) as JsonQuiz
        rowView.QuizTitle.setText(quiz.title)
        rowView.QuizDesc.setText(quiz.desc)

        return rowView
    }

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
}