package com.example.myproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set content view
        setContentView(R.layout.activity_main)

        // Buttons for other functionality
        val googleBtn: Button = findViewById(R.id.googleBtn)
        googleBtn.setOnClickListener {
            val google = "http://www.google.com"
            val webaddress = Uri.parse(google)
            val intent = Intent(Intent.ACTION_VIEW, webaddress)
            startActivity(intent)
        }

        val movielistBtn: Button = findViewById(R.id.movielistBtn)
        movielistBtn.setOnClickListener {
            val startIntent = Intent(this, ListActivity::class.java)
            startIntent.putExtra("com.example.myproject.SOMETHING", "HELLO WORLD!")
            startActivity(startIntent)
        }
    }
}
