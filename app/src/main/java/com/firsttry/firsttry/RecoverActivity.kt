package com.firsttry.firsttry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recover.*
import android.util.Log
import java.util.*

class RecoverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover)

        supportActionBar?.hide()


        acceptButton.setOnClickListener {
            val cardNum = cardNumText.text.toString()
            var (cardMonth, cardYear) = cardDateText.text.toString().split("/")
            val cardCVC = cvcText.text.toString()
            val curYear = Calendar.getInstance().get(Calendar.YEAR)
            when (cardYear.length){
                2-> cardYear = ("20" + cardYear)
                else -> cardYear
            }

            if (cardNum.length == 12 && cardCVC.length == 3 && cardMonth.toInt() in 0..12 && cardYear.toInt() in curYear-3..curYear+3) {
                val intent = Intent(this, MainActivity::class.java)
                finish()
                startActivity(intent)
            }
        }
    }
}