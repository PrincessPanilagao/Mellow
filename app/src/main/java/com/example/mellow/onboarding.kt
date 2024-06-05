package com.example.mellow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class onboarding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        // Get Started arrow Button
        val getStartedButton = findViewById<ImageButton>(R.id.getStartedButton)

        // Set OnClickListener to ImageButton
        getStartedButton.setOnClickListener {
            // Move to Login Activity
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }
}