package com.example.simplecalculator

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.lang.Exception
import kotlin.math.pow

class CalculatorService : Service() {
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val firstNumberVal:Double = intent.getDoubleExtra("FirstVal",0.0)
        val secondNumberVal:Double = intent.getDoubleExtra("SecondVal",0.0)
        val operation: String = intent.getStringExtra("Operation").toString()
        val newIntent = Intent("Calculate")
        val result: Double
        try {
            result = calculate(firstNumberVal,secondNumberVal,operation)
            newIntent.putExtra("Result",result)
            newIntent.putExtra("Status",1)
            sendBroadcast(newIntent)
        }
        catch (e:Exception)
        {
            newIntent.putExtra("Status",0)
            sendBroadcast(newIntent)
        }
        return super.onStartCommand(intent, flags, startId)
    }
    private fun calculate(firstNumberVal: Double, secondNumberVal : Double, operation: String): Double{
        var result = 0.0
        when (operation) {
            "+" -> result = firstNumberVal + secondNumberVal
            "-" -> result = firstNumberVal - secondNumberVal
            "*" -> result = firstNumberVal * secondNumberVal
            "/" -> {
                try {
                    if(secondNumberVal == 0.0) throw ArithmeticException("Деление на 0")
                    result = firstNumberVal / secondNumberVal
                }
                catch (e: ArithmeticException) {
                    Log.e("math",e.toString())
                    Toast.makeText(this,e.toString(), Toast.LENGTH_LONG).show()
                }
            }
            "^" -> result = firstNumberVal.pow(secondNumberVal)
            else -> {
                Toast.makeText(
                    this,
                    "This operation is not supported!!!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return result
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}