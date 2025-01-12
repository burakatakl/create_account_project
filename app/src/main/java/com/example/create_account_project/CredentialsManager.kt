package com.example.create_account_project
import android.content.Context
import android.content.pm.PackageInstaller.PreapprovalDetails

class CredentialsManager {

    private val PREFS_NAME = "user_prefs"
    private  val KEY_IS_LOGGED_IN = "is_logged_in"
    private  val KEY_EMAIL = "email"
    private  val KEY_PASSWORD = "password"



    private val emailPattern = ("[a-zA-Z0-9\\+\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][0-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][0-zA-Z0-9\\-]{0,25}" +
            ")+").toRegex()

    fun emailValid(email: String): Boolean {
        return email.matches(emailPattern)
    }

    fun validPassword(password: String): Boolean {
        return password.length >= 8
    }

    fun validateCredentials(email: String, password: String): Boolean {
        return emailValid(email) && validPassword(password)
    }

    fun validFullName(fullName: String): Boolean {
        return fullName.isNotEmpty()
    }

    fun isHardcodedCredentials(email: String, password: String): Boolean {
        val hardcodedEmail = "test@te.st"
        val hardcodedPassword = "1234"
        return email == hardcodedEmail && password == hardcodedPassword
    }

    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phonePattern = "^[0-9]{9,}$".toRegex()
        return phoneNumber.matches(phonePattern)
    }
    fun termsAccepted(isCheck: Boolean): Boolean{
        return isCheck
    }
    fun isMistakeCredentials(email: String, password: String):Boolean{
        val mistakeEmail = "burak@tt.omc"
        val mistakePassword = "b123"
        return email == mistakeEmail && password == mistakePassword
    }

    fun validateCredentialsForSignUp(
        fullName: String, email: String, phoneNumber: String,
        password: String, isCheck: Boolean
    ) : Boolean{
        return validFullName(fullName) && emailValid(email) && validPassword(password) &&
                isValidPhoneNumber(phoneNumber) && termsAccepted(isCheck)
    }
    private fun getSharedPreferences(context: Context) =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setLoggedIn(context: Context, isLoggedIn: Boolean) {
        getSharedPreferences(context).edit()
            .putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
            .apply()
    }


}
