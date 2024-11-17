package com.example.create_account_project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.CredentialsManager

class MainActivity2 : AppCompatActivity() {

    private lateinit var credentialsManager: CredentialsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        credentialsManager = CredentialsManager()

        val fullNameEditText = findViewById<EditText>(R.id.nameEditText)
        val emailEdit = findViewById<EditText>(R.id.emailEditText)
        val phoneNumberEdit = findViewById<EditText>(R.id.phoneNumberEdit)
        val passwdEdit = findViewById<EditText>(R.id.passwordEditText)
        val conditionCheckBox = findViewById<CheckBox>(R.id.rememberMeCheckBox)
        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener{
            val fullName = fullNameEditText.text.toString().trim()
            val email = emailEdit.text.toString().trim()
            val phoneNumber = phoneNumberEdit.text.toString().trim()
            val password = passwdEdit.text.toString().trim()
            val terms = conditionCheckBox.isChecked
        }

    }
}