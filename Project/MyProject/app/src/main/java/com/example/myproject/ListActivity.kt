package com.example.myproject

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListActivity  : AppCompatActivity() {

    private lateinit var myListView: ListView
    private lateinit var movies: Array<String>
    private lateinit var grades: Array<String>
    private lateinit var descriptions: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val res: Resources = resources
        myListView = findViewById(R.id.myListView)
        movies = res.getStringArray(R.array.movies)
        grades = res.getStringArray(R.array.grades)
        descriptions = res.getStringArray(R.array.descriptions)

        val itemAdapter = ItemAdapter(this, movies, grades, descriptions)
        myListView.adapter = itemAdapter

        myListView.setOnItemClickListener { adapterView, view, position, id ->
            val showDetailActivity = Intent(this, DetailActivity::class.java)
            showDetailActivity.putExtra("com.example.myproject.ITEM_INDEX", position)
            startActivity(showDetailActivity)
        }
    }
}