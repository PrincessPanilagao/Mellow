package com.example.mellow

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class ProfileFragment : Fragment() {

    private lateinit var fullName: TextView
    private lateinit var usernameDisplay: TextView
    private lateinit var emailDisplay: TextView
    private lateinit var pwDisplay: TextView
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var profilePic: ImageView
    private lateinit var chooseImage: ImageButton

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Item view initialization
        fullName = view.findViewById(R.id.fullnameDisplay)
        usernameDisplay = view.findViewById(R.id.usernameDisplay)
        emailDisplay = view.findViewById(R.id.emailDisplay)
        pwDisplay = view.findViewById(R.id.passwordDisplay)

        // Access the shared preferences (user name, email, pw)
        sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val fname = sharedPreferences.getString("fname", "")
        val lname = sharedPreferences.getString("lname", "")
        val email = sharedPreferences.getString("email", "")
        val pw = sharedPreferences.getString("pw", "")

        // Set text to the full name display
        fullName.text = "$fname $lname"
        // Set text to the username display
        usernameDisplay.text = "$fname $lname"
        // Set text to the email display
        emailDisplay.text = "$email"
        // Set text to the password display
        pwDisplay.text = "$pw"


        // For displaying profile pic
        profilePic = view.findViewById(R.id.profilePic)
        chooseImage = view.findViewById(R.id.chooseImage)

        // For choose image from gallery image button
        chooseImage.setOnClickListener {
            pickImageGallery()
        }
    }

    // Picking image from phone gallery
    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    // Displaying image in profile pic image view
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Getting image URI from phone gallery
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            profilePic.setImageURI(data?.data)
        }
    }
}