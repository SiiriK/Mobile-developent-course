package com.example.listapp

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var myListView: ListView
    private lateinit var items: Array<String>
    private lateinit var prices: Array<String>
    private lateinit var descriptions: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val res: Resources = resources
        myListView = findViewById(R.id.myListView)
        items = res.getStringArray(R.array.items)
        prices = res.getStringArray(R.array.prices)
        descriptions = res.getStringArray(R.array.descriptions)

        val itemAdapter = ItemAdapter(this, items, prices, descriptions)
        myListView.adapter = itemAdapter

        myListView.setOnItemClickListener { adapterView, view, position, id ->
            val showDetailActivity = Intent(this, DetailActivity::class.java)
            showDetailActivity.putExtra("com.example.listapp.ITEM_INDEX", position)
            startActivity(showDetailActivity)

        }
    }
}
