package com.example.simplecalculator

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

 class MainActivity : AppCompatActivity() {
    private lateinit var firstNumber: EditText
    private lateinit var secondNumber: EditText
    private lateinit var operation: EditText
    private lateinit var solveButton: Button
    private lateinit var answerText: TextView
    private val br: BroadcastReceiver = MyBroadcastReciever()
    private val filter = IntentFilter("Calculate")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstNumber = findViewById(R.id.editTextFirstNumber)
        secondNumber = findViewById(R.id.editTextSecondNumber)
        operation = findViewById(R.id.editTextOperation)
        solveButton = findViewById(R.id.solveButton)
        answerText = findViewById(R.id.answerText)
        registerReceiver(br,filter)
        solveButton.setOnClickListener{
            val firstNumberVal:Double = firstNumber.text.toString().toDouble()
            val secondNumberVal:Double = secondNumber.text.toString().toDouble()
            val operationVal:String = operation.text.toString()
            val intent = Intent(this,CalculatorService::class.java).putExtra("FirstVal",firstNumberVal).putExtra("SecondVal",secondNumberVal).putExtra("Operation",operationVal)
            startService(intent)
            }
        }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(br)
    }
    inner class MyBroadcastReciever: BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {
            val result: Double = intent.getDoubleExtra("Result",0.0)
            val status: Int = intent.getIntExtra("Status",0)
            if (status == 1)
            {
                answerText.text = result.toString()
            }
            else if (status == 0)
            {
                answerText.text = "Something went wrong"
            }
        }
    }
}
