package com.example.create_account_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText


class MainActivity2 : AppCompatActivity() {

    private val credentialsManager: CredentialsManager = CredentialsManager()

    private val fullNameFile: TextInputEditText
        get() = findViewById(R.id.nameEditText)
    private val fullNameLayout: TextInputEditText
        get() = findViewById(R.id.nameInput)
    private val phoneFile: TextInputEditText
        get() = findViewById(R.id.phoneNumberEdit)
    private val phoneLayout: TextInputEditText
        get() = findViewById(R.id.phoneNumberInput)
    private val emailFile: TextInputEditText
        get() = findViewById(R.id.emailEditText)
    private val emailLayout: TextInputEditText
        get() = findViewById(R.id.emailInputLayout)
    private val passwordFile: TextInputEditText
        get() = findViewById(R.id.passwordEditText)
    private val passwordLayout: TextInputEditText
        get() = findViewById(R.id.passwordInputLayout)
    private val checkBox: CheckBox
        get() = findViewById(R.id.rememberMeCheckBox)
    private val nextButton: Button
        get() = findViewById(R.id.nextButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        nextButton.setOnClickListener { handleNextButtonClick() }
        val loginButton = findViewById<TextView>(R.id.rememberLoginView)
        loginButton.setOnClickListener {
            val goToCreateAccount = Intent(this, MainActivity::class.java)
            startActivity(goToCreateAccount)
        }
    }

    private fun handleNextButtonClick(){

    }


}



