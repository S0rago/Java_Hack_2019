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

        acceptButton.setOnClickListener{
            val cardNum = cardNumText.text.toString()
            val cardDate = cardDateText.text.toString()
            val cardCVC = cvcText.text.toString()

            Toast.makeText(this, cardDate, Toast.LENGTH_SHORT)
                .show()
            if (cardNum.length == 12 && cardCVC.length == 3) {
                val intent = Intent(this, MainActivity::class.java)
                finish()
                startActivity(intent)
            }
        }

        resendSMSText.setOnClickListener {
            resendSMSText.isEnabled = false
            val timer = object: CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    resendSMSText.text = "Повторно можно отправить через ${millisUntilFinished/1000}"
                }
                override fun onFinish() {
                    resendSMSText.isEnabled = true
                    resendSMSText.text = "Оптравить смс повторно"
                }
            }
            timer.start()
        }
    }
}
