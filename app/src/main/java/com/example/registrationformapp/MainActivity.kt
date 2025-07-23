package com.example.registrationformapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var titleSpinner: Spinner
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSpinner()
        setupViews()
        setupButton()
    }

    private fun setupViews() {
        firstNameEditText = findViewById(R.id.edit_text_first_name)
        lastNameEditText = findViewById(R.id.edit_text_last_name)
        emailEditText = findViewById(R.id.edit_text_email)
        phoneNumberEditText = findViewById(R.id.edit_text_phone_number)
        passwordEditText = findViewById(R.id.edit_text_password)
    }

    private fun setupSpinner() {
        val titles = arrayOf("Miss", "Mrs", "Ms", "Mr", "Doctor", "Prof")

        titleSpinner = findViewById<Spinner>(R.id.spinner_title)
        val titleAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, titles)

        titleSpinner.adapter = titleAdapter
    }

    private fun setupButton() {
        val createAccountButton = findViewById<Button>(R.id.button_create_account)

        createAccountButton.setOnClickListener {
            createAccount()
        }
    }

    private fun createAccount() {
        val user = User(
            title = titleSpinner.selectedItem as String,
            firstName = firstNameEditText.text.toString(),
            lastName = lastNameEditText.text.toString(),
            email = emailEditText.text.toString(),
            phoneNumber = phoneNumberEditText.text.toString(),
            password = passwordEditText.text.toString()
        )

        val intent = Intent(this, SummaryActivity::class.java)
        intent.putExtra("User", user)
        startActivity(intent)
    }
}