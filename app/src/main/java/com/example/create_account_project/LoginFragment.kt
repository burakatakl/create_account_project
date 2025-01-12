package com.example.create_account_project

import android.content.Context
import android.content.Intent
import android.media.MediaCas.EventListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import java.io.FileDescriptor
import java.io.PrintWriter


class LoginFragment(val credentialsManager: CredentialsManager):Fragment(){
    private var listener: EventListener? = null
    interface EventsListener{
        fun onRegisterPressed()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        require(
            context is EventsListener,
            { "Activity holding fragment must implement it is EventsInterface" }
        )


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.nextButton).setOnClickListener {
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
        }
    }


}