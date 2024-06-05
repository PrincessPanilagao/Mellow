package com.example.mellow

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView

class HomeFragment : Fragment() {

    private lateinit var greetingsDisplay: TextView
    private lateinit var sharedPreferences: SharedPreferences

    // Array of life expectancy image resource IDs
    private val lifeExpectancyImageResources = arrayOf(
        R.drawable.le_1,
        R.drawable.le_2,
        R.drawable.le_3,
        R.drawable.le_4,
        R.drawable.le_5
    )

    // Array of unwind image resource IDs
    private val unwindImageResources = arrayOf(
        R.drawable.uw_1,
        R.drawable.uw_2,
        R.drawable.uw_3,
        R.drawable.uw_4,
        R.drawable.uw_5
    )

    // Array of self-confidence image resource IDs
    private val selfconfidenceImageResources = arrayOf(
        R.drawable.sc_1,
        R.drawable.sc_2,
        R.drawable.sc_3,
        R.drawable.sc_4,
        R.drawable.sc_5
    )

    // Array of peace of mind image resource IDs
    private val peaceofmindImageResources = arrayOf(
        R.drawable.pom_1,
        R.drawable.pom_2,
        R.drawable.pom_3,
        R.drawable.pom_4,
        R.drawable.pom_5
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        greetingsDisplay = view.findViewById(R.id.greetingDisplay)

        // Access the shared preferences
        sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val fname = sharedPreferences.getString("fname", "")

        // Set the text to the TextView
        greetingsDisplay.text = "Hello $fname!"


        // Find the life expectancy button by its ID
        val lifeExpectancyButton = view.findViewById<ImageButton>(R.id.lifeExpectancyButton)
        // Find the unwind button by its ID
        val unwindButton = view.findViewById<ImageButton>(R.id.unwindButton)
        // Find the self-confidence button by its ID
        val selfconfidenceButton = view.findViewById<ImageButton>(R.id.selfConfidenceButton)
        // Find the peace of mind button by its ID
        val peaceofmindButton = view.findViewById<ImageButton>(R.id.peaceofMindButton)

        // Set click listener to the life expectancy button
        lifeExpectancyButton.setOnClickListener {
            // Generate a random index for life expectancy images
            val randomIndex = (0 until lifeExpectancyImageResources.size).random()

            // Start the new activity
            startLifeExpectancyActivity(lifeExpectancyImageResources[randomIndex])
        }

        // Set click listener to the unwind button
        unwindButton.setOnClickListener {
            // Generate a random index for unwind images
            val randomIndex = (0 until unwindImageResources.size).random()

            // Start the new activity
            startLifeExpectancyActivity(unwindImageResources[randomIndex])
        }

        // Set click listener to the self confidence button
        selfconfidenceButton.setOnClickListener {
            // Generate a random index for unwind images
            val randomIndex = (0 until selfconfidenceImageResources.size).random()

            // Start the new activity
            startLifeExpectancyActivity(selfconfidenceImageResources[randomIndex])
        }

        // Set click listener to the peace of mind button
        peaceofmindButton.setOnClickListener {
            // Generate a random index for unwind images
            val randomIndex = (0 until peaceofmindImageResources.size).random()

            // Start the new activity
            startLifeExpectancyActivity(peaceofmindImageResources[randomIndex])
        }
    }

    // Display image source in Life Expectancy Activity
    // This is for display of outputs for all 4 buttons
    private fun startLifeExpectancyActivity(imageResource: Int) {
        val intent = Intent(activity, LifeExpectancy::class.java)
        intent.putExtra("imageResource", imageResource)

        // Apply fade-in animation
        startActivity(intent)
        activity?.overridePendingTransition(R.anim.fade_in, android.R.anim.fade_out)
    }
}