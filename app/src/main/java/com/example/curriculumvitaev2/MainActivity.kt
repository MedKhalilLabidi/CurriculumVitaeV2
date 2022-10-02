package com.example.curriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import android.util.Patterns.EMAIL_ADDRESS
var name :TextView?=null
var oName :TextInputLayout?=null
var email :TextView?=null
var oEmail :TextInputLayout?=null
var age :TextView?=null
var oAge :TextInputLayout?=null
var nextB :Button?=null
var male  :RadioButton?=null
var female:RadioButton?=null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      name = findViewById<TextView>(R.id.NameInput)
         oName = findViewById<TextInputLayout>(R.id.outlined_username)
         email = findViewById<TextView>(R.id.emailInput)
        oEmail = findViewById<TextInputLayout>(R.id.outlined_email)
         age = findViewById<TextView>(R.id.ageInput)
         oAge = findViewById<TextInputLayout>(R.id.outlined_age)
         nextB = findViewById<Button>(R.id.next)

          male=findViewById<RadioButton>(R.id.male)
        female=findViewById<RadioButton>(R.id.female)
        nextB!!.setOnClickListener {
            if(check())
            {

                val fullname = name!!.text.toString()
                val age2 = age!!.text.toString()
                val mail =  email!!.text.toString()
                var gender=""
                if(male!!.isChecked){
                    gender="Male";
                }
                else{
                    gender="Female"
                }

                val intent = Intent(this, step2::class.java)
                intent.putExtra("Name", fullname)
                intent.putExtra("Email", mail)
                intent.putExtra("Age", age2)
                intent.putExtra("Gender", gender)
                startActivity(intent)
            }
        }
    }
}    fun check():Boolean{
   var c1=false
    var c2=false;var
            c3=false
    if (name!!.text.isEmpty()) {
        oName?.error = "Must not be empty!"

    }
    else {
        oName?.error = null
        c1=true
    }
    if (email!!.text.isEmpty()) {
        oEmail?.error = "Must not be empty!"

    }
    else if(!EMAIL_ADDRESS.matcher(email?.text!!).matches()){
        oEmail?.error = "Check your email!"
    }
    else {
        oEmail?.error = null
         c2=true;

    }
    if (age!!.text.isEmpty()) {
        oAge?.error = "Must not be empty!"

    }
    else {
        oAge?.error = null
        c3=true;
    }
if(c1&&c2&&c3) {return true}
    else return false
}