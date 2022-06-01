package com.colosoft.udeaapp

import android.app.Activity
import android.os.Bundle
import com.colosoft.udeaapp.databinding.ActivityMainBinding

// TODO: Falta definir algo

class MainActivity : Activity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        with(mainBinding) {
            registerButton.setOnClickListener {
                val name = nameText.text.toString()
                val lastName = lastNameText.text.toString()
                val email = emailText.text.toString()

                infoTextView.text = getString(R.string.info, name, lastName, email)
            }
        }


    }
}

//Modificacion