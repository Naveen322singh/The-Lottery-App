package com.example.lotteryapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    lateinit var TextViewtitle:TextView
    lateinit var resultTextView: TextView
    lateinit var shareBtn:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        TextViewtitle=findViewById(R.id.outputTextView)
        resultTextView=findViewById(R.id.resultTextView)
        shareBtn=findViewById(R.id.shareBtn)
        //generate 6 random numbers and store them in a string
        val randomNumbers=generateRandomNumbers(6)
        resultTextView.text=randomNumbers

        // getting the username from the main activity
        var username=receiveUserName()

        // sharing the username and generated number with email app
        shareBtn.setOnClickListener{
            shareResult(username,randomNumbers)
        }
    }
    //function to generate random numbers
    fun generateRandomNumbers(count:Int):String
    {
        //create a list of random numbers
        var randomNumbers=List(count) {
            (0..42).random()
        }
        // convert the list of numbers to a string
        return randomNumbers.joinToString(" ")
    }

    fun receiveUserName():String{
        //retrieve the extras that were added to an Intent
        // ? --> Indicates that the variable can be null
        var bundle:Bundle?=intent.extras

        //give me the key i'll give you the value
        var username = bundle?.getString("username").toString()
        return username
    }

    fun shareResult(username:String,generatedNums:String)
    {
        // implicit intents
        // sending data to another app
        var i=Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT,"$username generates these numbers")
        i.putExtra(Intent.EXTRA_TEXT,"The lottery numbers are: $generatedNums")
        startActivity(i)
    }

}