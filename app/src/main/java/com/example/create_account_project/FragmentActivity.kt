package com.example.create_account_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class FragmentSampleActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<View>(R.id.fragment_button).setOnClickListener {
            supportFragmentManager.commit {
                val currentFragment = supportFragmentManager.findFragmentById(
                    R.id.fragment_container
                )
                if (currentFragment is FragmentA) {
                    replace<FragmentB>(R.id.fragment_container)
                    addToBackStack(null)
                } else {
                    supportFragmentManager.popBackStack()
                }
            }
        }
    }
}