package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.R

class MainActivity : AppCompatActivity() {
    private lateinit var operation: String
    private var operand: Double = 0.0
    private lateinit var resultTextView: TextView
    private lateinit var decButton: TextView
    private lateinit var eqButton: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.textView)
        decButton = findViewById(R.id.decimalButton)
        eqButton = findViewById(R.id.equalButton)
    }


    fun numberClick(clickedView: View) {
        if (clickedView is TextView) {

            var text = resultTextView.text.toString()
            val number = clickedView.text.toString()
            if (text == "0") {
                text = ""
            }
            if (number == ".") {
                decButton.isClickable=false

            }
            val result = text + number

            resultTextView.text = result
        }
    }

    fun operationClick(clickedView: View) {
        decButton.isClickable=true
        if (clickedView is TextView) {
            this.operand = resultTextView.text.toString().toDouble()
            this.operation = clickedView.text.toString()
            resultTextView.text = ""
        }

    }

    fun equalsClick(clickedView: View) {
        val secOperand = resultTextView.text.toString().toDouble()
        when(operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "÷" -> resultTextView.text = (operand / secOperand).toString()

        }
        var text = resultTextView.text.toString()

        if (clickedView is TextView){
            if (text.endsWith(".0")) {
                text = text.replace(".0", "")
            }
            val result = text
            resultTextView.text = result
        }
    }

    fun clearClick(clickedView: View) {
        val result = "0"
        decButton.isClickable=true

        resultTextView.text = result

    }



    fun delClick(clickedView: View) {
        val text = resultTextView.text.toString()
        if (clickedView is TextView) {
            resultTextView.text = text.dropLast(1)
            if (text.length == 1) {
                resultTextView.text = "0"
            }
        }


    }



}