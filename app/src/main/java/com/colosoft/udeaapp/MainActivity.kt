package com.colosoft.udeaapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.colosoft.udeaapp.databinding.ActivityMainBinding

// TODO: Falta definir algo

class MainActivity : Activity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.registerButton.setOnClickListener{
            val name = mainBinding.nameEditText.text.toString()
            val lastName = mainBinding.lastNameEditText.text.toString()
            val email = mainBinding.emailEditText.text.toString()

            mainBinding.infoTextView.text = name+"\n"+lastName+"\n"+email
        }
    }
}

//Modificacion