package com.colosoft.udeaapp

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import com.colosoft.udeaapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

// TODO: Falta definir algo

class MainActivity : Activity() {

    private lateinit var mainBinding: ActivityMainBinding
    private var bornDate = ""
    private var bornDateChanged= false
    private val calendar = Calendar.getInstance()


    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val format = "dd/MM/YY"
            val sdf = SimpleDateFormat(format)
            bornDate = sdf.format(calendar.time).toString()
            mainBinding.dateButton.text = bornDate
            bornDateChanged = true
        }

        with(mainBinding) {

            dateButton.setOnClickListener{
                DatePickerDialog(this@MainActivity,
                    dateSetListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }


            registerButton.setOnClickListener {

                val name = nameText.text.toString()
                val lastName = lastNameText.text.toString()
                val email = emailText.text.toString()

                val genre = if (radioButtonFemale.isChecked) getString(R.string.female)
                else if (radioButtonMale.isChecked) getString(R.string.male)
                else getString(R.string.otherGender)

                var hobbies =""
                if (exerciseCheckBox.isChecked) hobbies += getString(R.string.exercise)+" "
                if (readingCheckBox.isChecked) hobbies += getString(R.string.reading)+" "
                if (gamingCheckBox.isChecked) hobbies += getString(R.string.gaming)+" "
                if (travelingCheckBox.isChecked) hobbies += getString(R.string.traveling)+" "

                val bornCity = birthdayPlaceSpinner.selectedItem.toString()

                if (nameText.text.toString().isNotEmpty() && lastNameText.text.toString().isNotEmpty() && emailText.text.toString().isNotEmpty() &&
                    passwordText.text.toString().isNotEmpty() && confirmPasswordText.text.toString().isNotEmpty() &&
                    (exerciseCheckBox.isChecked || readingCheckBox.isChecked || gamingCheckBox.isChecked || travelingCheckBox.isChecked) &&
                        bornDateChanged){
                    if (passwordText.text.toString() == confirmPasswordText.text.toString()){
                        infoTextView.text = getString(R.string.info, name, lastName, email, genre, hobbies, bornDate, bornCity)
                        Toast.makeText(this@MainActivity, getString(R.string.success_message),Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this@MainActivity, getString(R.string.not_matching_passwords_message),Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this@MainActivity, getString(R.string.missing_fill_message),Toast.LENGTH_SHORT).show()
                }

            }
        }


    }
}

//Modificacion