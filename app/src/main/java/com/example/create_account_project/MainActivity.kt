package com.example.create_account_project


import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.content.Intent
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private val credentialsManager: CredentialsManager = CredentialsManager()
    private val emailFile: TextInputEditText
        get() = findViewById(R.id.emailEditText)
    private val emailLayout: TextInputEditText
        get() = findViewById(R.id.emailInputLayout)
    private val passwordFile: TextInputEditText
        get() = findViewById(R.id.passwordEditText)
    private val passwordLayout: TextInputEditText
        get() = findViewById(R.id.passwordInputLayout)
    private val nextButton: Button
        get() = findViewById(R.id.nextButton)
    private val rememberCheckBox: CheckBox
        get() = findViewById(R.id.rememberMeCheckBox)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton.setOnClickListener { nextButtonClick() }
        val loginButton = findViewById<TextView>(R.id.registernow)
        loginButton.setOnClickListener {
            val goToReg = Intent(this, MainActivity2::class.java)
            startActivity(goToReg)
        }
    }

    private fun setError(field: EditText, errorResId: Int) {
        field.error = getString(errorResId)
    }

    private fun nextButtonClick() {



    }

}

