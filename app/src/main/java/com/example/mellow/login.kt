package com.example.mellow

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class login : AppCompatActivity() {

    private lateinit var fnameInput: EditText
    private lateinit var lnameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var pwInput: EditText
    private lateinit var signUpButton: ImageButton
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initializing login items
        fnameInput = findViewById(R.id.fnameInput)
        lnameInput = findViewById(R.id.lnameInput)
        emailInput = findViewById(R.id.emailInput)
        pwInput = findViewById(R.id.pwInput)
        signUpButton = findViewById(R.id.signUpButton)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Set OnClickListener to ImageButton
        signUpButton.setOnClickListener {
            // Storing Edit Texts to String
            val fnameText = fnameInput.text.toString()
            val lnameText = lnameInput.text.toString()
            val emailText = emailInput.text.toString()
            val pwText = pwInput.text.toString()

            // Check if any field is empty
            if (fnameText.isEmpty() || lnameText.isEmpty() || emailText.isEmpty() || pwText.isEmpty()) {
                // Toast message to inform user to fill all required fields
                Toast.makeText(this, "Fill up all required fields!", Toast.LENGTH_SHORT).show()
            } else {
                // Storing Edit Texts to String
                val capitalizedFname = capitalizeFirstLetter(fnameText)
                val capitalizedLname = capitalizeFirstLetter(lnameText)
                val editor = sharedPreferences.edit()

                // Put strings in editor
                editor.putString("fname", capitalizedFname)
                editor.putString("lname", capitalizedLname)
                editor.putString("email", emailText)
                editor.putString("pw", pwText)

                editor.apply()

                // Move to Main Activity Screen
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        // Set OnClickListener to toggle password visibility
        val togglePassword: ImageButton = findViewById(R.id.togglePassword)
        var isPasswordVisible = false
        togglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                // Show password
                pwInput.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                togglePassword.setImageResource(R.drawable.ic_pw_unhide)
            } else {
                // Hide password
                pwInput.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                togglePassword.setImageResource(R.drawable.ic_pw_hide)
            }
            // Move cursor to the end of the text
            pwInput.setSelection(pwInput.length())
        }
    }

    // Capitalize first letter of names
    private fun capitalizeFirstLetter(input: String): String {
        return input.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}