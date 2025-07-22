package com.example.registrationformapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SummaryActivity : AppCompatActivity() {
    private lateinit var user: User;
    private lateinit var fullNameTextView: TextView
    private lateinit var emailAddressTextView: TextView
    private lateinit var phoneNumberTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        setupViews()
        retrieveUser()
        displayUser()
        setupClickListeners()
    }

    private fun setupViews() {
        fullNameTextView = findViewById(R.id.text_view_full_name)
        emailAddressTextView = findViewById(R.id.text_view_email_address)
        phoneNumberTextView = findViewById(R.id.text_view_phone_number)
    }

    private fun retrieveUser() {
        user = intent.getSerializableExtra("User") as User
    }

    private fun displayUser() {
        fullNameTextView.text = user.getFullName()
        emailAddressTextView.text = user.email
        phoneNumberTextView.text = user.phoneNumber
    }

    private fun setupClickListeners() {
        emailAddressTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.email}")
            startActivity(intent)
        }
        phoneNumberTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phoneNumber}")
            startActivity(intent)
        }
    }
}