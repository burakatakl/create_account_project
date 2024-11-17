package com.example.create_account_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast


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

        nextButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString().trim()
            val email = emailEdit.text.toString().trim()
            val phoneNumber = phoneNumberEdit.text.toString().trim()
            val password = passwdEdit.text.toString().trim()
            val terms = conditionCheckBox.isChecked
        }


        val loginButton = findViewById<View>(R.id.rememberLoginView)
        loginButton.setOnClickListener {
            val goToReg = Intent(this, MainActivity::class.java)
            startActivity(goToReg)
        }
    }


}
