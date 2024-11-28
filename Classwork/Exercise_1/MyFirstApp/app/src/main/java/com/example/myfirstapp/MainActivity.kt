package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val addBtn: Button = findViewById(R.id.addBtn)
        val firstNumEditText: EditText = findViewById(R.id.FirstNumText)
        val secNumEditText: EditText = findViewById(R.id.SecNumText)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        addBtn.setOnClickListener {
            val num1 = firstNumEditText.text.toString().toIntOrNull() ?: 0
            val num2 = secNumEditText.text.toString().toIntOrNull() ?: 0
            val result = num1 + num2
            
            resultTextView.text = result.toString()
        }
    }
}
