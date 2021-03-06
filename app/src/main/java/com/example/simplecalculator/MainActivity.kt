package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var firstNumber: EditText
    private lateinit var secondNumber: EditText
    private lateinit var operation: EditText
    private lateinit var solveButton: Button
    private lateinit var answerText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstNumber = findViewById(R.id.editTextFirstNumber)
        secondNumber = findViewById(R.id.editTextSecondNumber)
        operation = findViewById(R.id.editTextOperation)
        solveButton = findViewById(R.id.solveButton)
        answerText = findViewById(R.id.answerText)
        solveButton.setOnClickListener{
            var result = 0.0
            val firstNumberVal:Double = firstNumber.text.toString().toDouble()
            val secondNumberVal:Double = secondNumber.text.toString().toDouble()
            when(operation.text.toString()) {
                "+" -> result = firstNumberVal + secondNumberVal
                "-" -> result = firstNumberVal - secondNumberVal
                "*" -> result = firstNumberVal * secondNumberVal
                "/" -> {
                    result = if (secondNumberVal != 0.0)
                        firstNumberVal / secondNumberVal
                    else
                        0.0
                }
                "^" -> result = firstNumberVal.pow(secondNumberVal)
                else -> {
                    Toast.makeText(this,"This operation is not supported!!!",Toast.LENGTH_LONG).show()
                }
            }
            answerText.text = result.toString()
        }

    }

}