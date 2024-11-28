package com.example.listapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val index = intent.getIntExtra("com.example.listapp.ITEM_INDEX", -1)

        if (index > -1) {
            val pic = getImage(index)
            val img = findViewById<ImageView>(R.id.imageView)
            scaleImg(img, pic)
        }
    }

    private fun getImage(index: Int): Int {
        return when (index) {
            0 -> R.drawable.peach
            1 -> R.drawable.tomato
            2 -> R.drawable.squash
            else -> -1
        }
    }

    private fun scaleImg(img: ImageView, pic: Int) {
        // Use DisplayMetrics to get screen dimensions
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        val screenWidth = metrics.widthPixels

        val options = BitmapFactory.Options().apply {
            inJustDecodeBounds = true
        }

        // Decode the resource to get the dimensions
        BitmapFactory.decodeResource(resources, pic, options)
        val imgWidth = options.outWidth

        if (imgWidth > screenWidth) {
            val ratio = Math.round(imgWidth.toFloat() / screenWidth.toFloat())
            options.inSampleSize = ratio
        }

        options.inJustDecodeBounds = false
        val scaledImg: Bitmap = BitmapFactory.decodeResource(resources, pic, options)

        // Set the ImageView's layout parameters to match parent width
        img.layoutParams.width = screenWidth
        img.layoutParams.height = (scaledImg.height * (screenWidth.toFloat() / scaledImg.width)).toInt()
        img.setImageBitmap(scaledImg)
    }
}
