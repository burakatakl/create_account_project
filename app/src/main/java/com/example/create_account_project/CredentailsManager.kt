package com.example.create_account_project;

import android.provider.ContactsContract.CommonDataKinds.Email

public class CredentailsManager {
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

}
