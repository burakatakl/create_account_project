package com.example.create_account_project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
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

    private fun handleNextButtonClick() {
        val fullName = fullNameFile.text.toString().trim()
        val email = emailFile.text.toString().trim()
        val password = passwordFile.toString().trim()
        val phone = phoneFile.toString().trim()
        val terms = checkBox.isChecked
        clearError(fullNameLayout, message = "error")
        clearError(emailLayout, message = "error")
        clearError(phoneLayout, message = "error")
        clearError(passwordLayout, message = "error")

        if (fullName.isNotEmpty()) {
            setError(fullNameLayout, message = "error")
            return
        }
        if (email.isEmpty() || !credentialsManager.emailValid(email)) {
            setError(emailLayout, message = "error")
            return
        }
        if (phone.isEmpty() || !credentialsManager.isValidPhoneNumber(phone)) {
            setError(phoneLayout, message = "error")
            return
        }
        if (password.isEmpty() || !credentialsManager.validPassword(password)) {
            setError(passwordLayout, message = "error")
            return
        }
        if (!terms) {
            showToast("check it ")
            return
        }

    }

    private fun setError(layout: TextInputEditText, message: String) {
        layout.error = message
    }

    private fun clearError(layout: TextInputEditText, message: String) {
        layout.error = null
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}



