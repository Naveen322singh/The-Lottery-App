package com.example.lotteryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var inputEditText: EditText
    lateinit var generateButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView=findViewById(R.id.introTextView)
        inputEditText=findViewById(R.id.inputEditText)
        generateButton=findViewById(R.id.myBtn)

        generateButton.setOnClickListener{
            var name:String=inputEditText.text.toString()

            var i=Intent(this,SecondActivity::class.java)
            i.putExtra("username",name)
            startActivity(i)
        }



    }
}
