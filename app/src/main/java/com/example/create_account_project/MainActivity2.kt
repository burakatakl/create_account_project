package com.example.create_account_project

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText


class MainActivity2 : Fragment() {

    private val credentialsManager: CredentialsManager = CredentialsManager()

    private lateinit var fullNameFile:TextInputEditText
    private lateinit var fullNameLayout:TextInputEditText
    private lateinit var emailFile:TextInputEditText
    private lateinit var emailLayout:TextInputEditText
    private lateinit var passwordFile:TextInputEditText
    private lateinit var passwordLayout:TextInputEditText
    private lateinit var phoneFile:TextInputEditText
    private lateinit var phoneLayout:TextInputEditText
    private lateinit var checkBox:CheckBox
    private lateinit var nextButton:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_main2,container,false)
        fullNameFile = view.findViewById(R.id.nameInput)
        fullNameLayout = view.findViewById(R.id.nameEditText)
        emailFile = view.findViewById(R.id.emailInputLayout)
        emailLayout = view.findViewById(R.id.emailEditText)
        passwordFile = view.findViewById(R.id.passwordInputLayout)
        passwordLayout = view.findViewById(R.id.passwordEditText)
        phoneFile = view.findViewById(R.id.phoneNumberInput)
        phoneLayout = view.findViewById(R.id.phoneNumberEdit)
        checkBox = view.findViewById(R.id.rememberMeCheckBox)
        nextButton = view.findViewById(R.id.nextButton)
        nextButton.setOnClickListener{handleNextButtonClick()}
        view.findViewById<TextView>(R.id.registernow).setOnClickListener(){

        }
        return view
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

    }

    private fun setError(layout: TextInputEditText, message: String) {
        layout.error = message
    }

    private fun clearError(layout: TextInputEditText, message: String) {
        layout.error = null
    }

    private fun showToast(messageResId: Int){
        Toast.makeText(requireContext(),getString(messageResId),Toast.LENGTH_SHORT).show()
    }
    

}



