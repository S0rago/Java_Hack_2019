package com.firsttry.firsttry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_recover.*
import android.widget.Toast

class RecoverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover)

        supportActionBar?.hide()

        acceptButton.setOnClickListener {
            val cardNum = cardNumText.text.toString()
            val cardDate = cardDateText.text.toString()
            val cardCVC = cvcText.text.toString()

            if (cardNum.length == 12 && cardCVC.length == 3) {
                val intent = Intent(this, MainActivity::class.java)
                finish()
                startActivity(intent)
            }
        }
    }
}