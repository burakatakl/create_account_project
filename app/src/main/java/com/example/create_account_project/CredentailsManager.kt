package com.example.create_account_project;

class CredentialsManager{


    private val emailPattern = ("[a-zA-Z0-9\\+\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][0-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][0-zA-Z0-9\\-]{0,25}" +
            ")+").toRegex()

    fun isEmailValid(email: String): Boolean{
        return email.matches(emailPattern)
    }
    fun isValidPasswd(password: String): Boolean{
        return password.length >= 10
    }
    fun validateCredentials(email: String, password: String, isCheckboxChecked: Boolean):Boolean{
        return isEmailValid(email) && isValidPasswd(password) && isCheckboxChecked
    }


}
