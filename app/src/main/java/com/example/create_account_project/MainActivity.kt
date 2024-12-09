package com.example.create_account_project

import  android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import  androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

class MainActivity(credentialsManager: CredentialsManager) : Fragment() {
    private val credentialsManager: CredentialsManager = CredentialsManager()

    private lateinit var emailFile: TextInputEditText
    private lateinit var emailLayout: TextInputEditText
    private lateinit var passwordFile: TextInputEditText
    private lateinit var passwordLayout: TextInputEditText
    private lateinit var nextButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_main, container, false)

        emailFile = view.findViewById(R.id.emailEditText)
        emailLayout = view.findViewById(R.id.emailInputLayout)
        passwordFile = view.findViewById(R.id.passwordEditText)
        passwordLayout = view.findViewById(R.id.passwordInputLayout)
        nextButton = view.findViewById(R.id.nextButton)

        nextButton.setOnClickListener { nextButtonClick() }

        view.findViewById<TextView>(R.id.registernow).setOnClickListener {
            navigateToMainActivity()
        }
        return view
    }


    private fun nextButtonClick() {
        val email = emailFile.text.toString().trim()
        val password = passwordFile.text.toString().trim()
        if (credentialsManager.isMistakeCredentials(email, password)) {
            navigateMain()
            return
        }
    }

    private fun setError(layout: TextInputEditText, message: String) {
        layout.error = message
    }

    private fun clearError(layout: TextInputEditText, message: String) {
        layout.error = null
    }


    private fun navigateToMainActivity() {
        clearError(emailLayout, message = "error")
        clearError(passwordLayout, message = "error")

    }
    private fun showToast(messageResId: Int){
        Toast.makeText(requireContext(),getString(messageResId),Toast.LENGTH_SHORT).show()
    }
    private fun navigateMain(){
        showToast(R.string.sign_name_massage)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,MainActivity(credentialsManager))
            .commit()
    }
    private fun navigateMain2(){
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,MainActivity2())
            .addToBackStack(null)
            .commit()
    }


}







