package com.example.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var skipResultBTN: ImageView
    private lateinit var bmiFlagImgView:ImageView
    private lateinit var advice1IMG: ImageView
    private lateinit var advice2IMG: ImageView
    private lateinit var advice3IMG: ImageView
    private lateinit var containerR: LinearLayout
    private lateinit var bmiValueTV: TextView
    private lateinit var bmiLabelTV: TextView
    private lateinit var commentTV: TextView
    private lateinit var advice1TV: TextView
    private lateinit var advice2TV: TextView
    private lateinit var advice3TV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        skipResultBTN = findViewById(R.id.skipResultBTN)
        containerR = findViewById(R.id.containerR)
        bmiValueTV = findViewById(R.id.bmiValueTV)
        bmiFlagImgView = findViewById(R.id.bmiFlagImgView)
        bmiLabelTV = findViewById(R.id.bmiLabelTV)
        commentTV = findViewById(R.id.commentTV)
        advice1IMG = findViewById(R.id.advice1IMG)
        advice1TV = findViewById(R.id.advice1TV)
        advice2IMG = findViewById(R.id.advice2IMG)
        advice2TV = findViewById(R.id.advice2TV)
        advice3IMG = findViewById(R.id.advice3IMG)
        advice3TV = findViewById(R.id.advice3TV)

        skipResultBTN.setOnClickListener {
            startActivity( Intent(this@ResultActivity,  MainActivity::class.java))
        }
        val bmi = intent.getDoubleExtra("bmi", -1.0)
        if (bmi == -1.0) {
            containerR.visibility= View.GONE
        } else {
            bmiValueTV.text=bmi.toString()
            if (bmi < 18.5) {
                containerR.setBackgroundResource(R.color.colorYellow)
                bmiFlagImgView.setImageResource(R.drawable.exclamationmark)
                bmiLabelTV.text="You have an UnderWeight!"
                commentTV.text="Here are some advices To help you increase your weight"
                advice1IMG.setImageResource(R.drawable.nowater)
                advice1TV.text="Don't drink water before meals"
                advice2IMG.setImageResource(R.drawable.bigmeal)
                advice2TV.text="Use bigger plates"
                advice3TV.text="Get quality sleep"

            } else {
                if (bmi > 25) {
                    containerR.setBackgroundResource(R.color.colorRed)
                    bmiFlagImgView.setImageResource(R.drawable.warning)
                    bmiLabelTV.text="You have an OverWeight!"
                    commentTV.text="Here are some advices To help you decrease your weight"
                    advice1IMG.setImageResource(R.drawable.water)
                    advice1TV.text="Drink water a half hour before meals"
                    advice2IMG.setImageResource(R.drawable.twoeggs)
                    advice2TV.text="Eeat only two meals per day and make sure that they contains a high protein"
                    advice3IMG.setImageResource(R.drawable.nosugar)
                    advice3TV.text="Drink coffee or tea and Avoid sugary food"
                }
            }
        }
    }
}
