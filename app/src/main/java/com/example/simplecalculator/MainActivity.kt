package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var firstNumber: EditText
    lateinit var secondNumber: EditText
    lateinit var operation: EditText
    lateinit var solveButton: Button
    lateinit var answerText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstNumber = findViewById(R.id.editTextFirstNumber)
        secondNumber = findViewById(R.id.editTextSecondNumber)
        operation = findViewById(R.id.editTextOperation)
        solveButton = findViewById(R.id.solveButton)
        answerText = findViewById(R.id.answerText)
        solveButton.setOnClickListener{
            var firstNumberVal:Int
            var secondNumberVal:Int
            var operationVal:String

        }

    }

}