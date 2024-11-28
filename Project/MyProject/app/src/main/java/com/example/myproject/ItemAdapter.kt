package com.example.myproject

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat

class ItemAdapter(
    private val context: Context,
    private val movies: Array<String>,
    private val grades: Array<String>,
    private val descriptions: Array<String>
) : BaseAdapter() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return movies.size
    }

    override fun getItem(position: Int): Any {
        return movies[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: mInflater.inflate(R.layout.my_listview_detail, parent, false)

        // Find the TextViews within the inflated layout
        val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        val gradeTextView = view.findViewById<TextView>(R.id.gradeTextView)

        nameTextView.text = movies[position]
        descriptionTextView.text = descriptions[position]

        // Get the grade and apply style
        val grade = grades[position]
        val starSymbol = "★ "

        // Create SpannableString
        val fullText = starSymbol + grade
        val spannable = SpannableString(fullText)

        // Set the star symbol color to yellow
        spannable.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.yellow)),
            0, starSymbol.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Set the grade color (black or any other color)
        spannable.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.black)),
            starSymbol.length, fullText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Set the text to the grade TextView
        gradeTextView.text = spannable

        return view
    }
}
