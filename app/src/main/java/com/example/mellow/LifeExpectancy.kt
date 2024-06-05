package com.example.mellow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class LifeExpectancy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_expectancy)

        // Get the image resource ID passed from the previous activity
        val imageResource = intent.getIntExtra("imageResource", 0)

        // Display randomized reflection in image display
        val reflectionDisplay = findViewById<ImageView>(R.id.reflectionDisplay)
        reflectionDisplay.setImageResource(imageResource)

        // Find the back button by its ID
        val backButton = findViewById<ImageView>(R.id.backButton)
        // Set click listener to the back button
        backButton.setOnClickListener {
            // Finish the current activity to return to the previous activity or fragment
            finish()
        }
    }
}
