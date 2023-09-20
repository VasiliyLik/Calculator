package com.bignerdranch.android.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bignerdranch.android.calculator.R.id
import com.bignerdranch.android.calculator.R.id.toolbar
import com.bignerdranch.android.calculator.R.layout
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var mathOperation: TextView
    private lateinit var resultText: TextView
    private lateinit var clear: TextView
    private lateinit var leftBracket: TextView
    private lateinit var rightBracket: TextView
    private lateinit var division: TextView
    private lateinit var btn7: TextView
    private lateinit var btn8: TextView
    private lateinit var btn9: TextView
    private lateinit var mult: TextView
    private lateinit var btn4: TextView
    private lateinit var btn5: TextView
    private lateinit var btn6: TextView
    private lateinit var plus: TextView
    private lateinit var btn1: TextView
    private lateinit var btn2: TextView
    private lateinit var btn3: TextView
    private lateinit var minus: TextView
    private lateinit var dot: TextView
    private lateinit var btn0: TextView
    private lateinit var back: TextView
    private lateinit var equal: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        val toolbar: Toolbar = findViewById(toolbar)
        setSupportActionBar(toolbar)
        title = "Calculator"
//        Toolbar toolbar = (Toolbar) findViewById(id.toolbar)
//        setSupportActionBar(toolbar)
        mathOperation = findViewById(id.math_operation)
        resultText = findViewById(id.result_text)
        clear = findViewById(id.clear_btn)
        leftBracket = findViewById(id.leftBracket_btn)
        rightBracket = findViewById(id.rightBracket_btn)
        division = findViewById(id.division_btn)
        btn7 = findViewById(id.btn_7)
        btn8 = findViewById(id.btn_8)
        btn9 = findViewById(id.btn_9)

        mult = findViewById(id.mult_btn)
        btn4 = findViewById(id.btn_4)
        btn5 = findViewById(id.btn_5)
        btn6 = findViewById(id.btn_6)

        plus = findViewById(id.plus_btn)
        btn1 = findViewById(id.btn_1)
        btn2 = findViewById(id.btn_2)
        btn3 = findViewById(id.btn_3)

        minus = findViewById(id.minus_btn)
        dot = findViewById(id.dot_btn)
        btn0 = findViewById(id.btn_0)
        back = findViewById(id.back_btn)
        equal = findViewById(id.equal_btn)

        btn0.setOnClickListener {setTextFields("0")}
        btn1.setOnClickListener {setTextFields("1")}
        btn2.setOnClickListener {setTextFields("2")}
        btn3.setOnClickListener {setTextFields("3")}
        btn4.setOnClickListener {setTextFields("4")}
        btn5.setOnClickListener {setTextFields("5")}
        btn6.setOnClickListener {setTextFields("6")}
        btn7.setOnClickListener {setTextFields("7")}
        btn8.setOnClickListener {setTextFields("8")}
        btn9.setOnClickListener {setTextFields("9")}
        leftBracket.setOnClickListener {setTextFields("(")}
        rightBracket.setOnClickListener {setTextFields(")")}
        mult.setOnClickListener {setTextFields("*")}
        division.setOnClickListener {setTextFields("/")}
        plus.setOnClickListener {setTextFields("+")}
        minus.setOnClickListener {setTextFields("-")}

        clear.setOnClickListener {
            mathOperation.text = ""
            resultText.text = ""
        }
        back.setOnClickListener {
            val str = mathOperation.text.toString()
            if (str.isNotEmpty()) {
                mathOperation.text = str.substring(0, str.length - 1)
            }
            resultText.text = ""
        }
        equal.setOnClickListener {
            try {
val ex = ExpressionBuilder(mathOperation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    resultText.text = longRes.toString()
                else
                    resultText.text = result.toString()
            } catch (e:Exception) {
                Log.d("Error", "message: ${e.message}")
            }
        }
    }

    private fun setTextFields(str: String) {
        mathOperation.append(str)
        if (resultText.text != "") {
            mathOperation.text = resultText.text
            resultText.text = ""
        }

    }
}