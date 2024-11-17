package com.example.create_account_project


import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailField = findViewById<EditText>(R.id.emailEditText)
        val passwordField = findViewById<EditText>(R.id.passwordEditText)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val CheckedBox = findViewById<CheckBox>(R.id.rememberMeCheckBox)

        nextButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val rememberMe = CheckedBox.isChecked
        }
        val loginButton = findViewById<View>(R.id.registernow)
        loginButton.setOnClickListener {
            val goToReg = Intent(this, MainActivity2::class.java)
            startActivity(goToReg)
        }
    }
    private fun setError(field: EditText, errorResId: Int) {
        field.error = getString(errorResId)
    }

    private fun showToast(messageResId: Int) {
        Toast.makeText(this, getString(messageResId), Toast.LENGTH_SHORT).show()
    }

}

