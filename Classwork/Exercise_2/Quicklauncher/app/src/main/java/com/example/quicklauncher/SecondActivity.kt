package com.example.quicklauncher

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        intent.getStringExtra("com.example.quicklauncher.SOMETHING")?.let { text ->
            val tv: TextView = findViewById(R.id.textView)
            tv.text = text
        }
    }
}
