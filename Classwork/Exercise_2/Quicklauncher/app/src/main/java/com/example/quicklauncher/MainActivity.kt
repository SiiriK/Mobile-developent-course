package com.example.quicklauncher

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicklauncher.ui.theme.QuicklauncherTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondActivityBtn: Button = findViewById(R.id.secondActivityBtn)
        secondActivityBtn.setOnClickListener {
            val startIntent = Intent(this, SecondActivity::class.java)
            startIntent.putExtra("com.example.quicklauncher.SOMETHING", "HELLO WORLD!")
            startActivity(startIntent)
        }
        val googleBtn: Button = findViewById(R.id.googleBtn)
        googleBtn.setOnClickListener {
            val google = "http://www.google.com"
            val webaddress = Uri.parse(google)
            val intent = Intent(Intent.ACTION_VIEW, webaddress)
            startActivity(intent)
        }
    }
}
