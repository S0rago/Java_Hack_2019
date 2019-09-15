package com.firsttry.firsttry

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recover.*
import kotlinx.android.synthetic.main.activity_verify.*

class VerifyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)

        supportActionBar?.hide()

        val codeList = listOf("1234", "1357", "2468")
        codeVerButton.setOnClickListener {
            val code = smsCodeText.text.toString()
            if(code.length == 4 && codeList.contains(code)){
                val intent = Intent(this, MainMenuActivity::class.java)
                finish()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Неверно введен код", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        resendVerifyText.setOnClickListener{
            resendVerifyText.isEnabled = false
            val timer = object: CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    resendVerifyText.text = "Повторно можно отправить через ${millisUntilFinished/1000}"
                }
                override fun onFinish() {
                    resendVerifyText.isEnabled = true
                    resendVerifyText.text = "Оптравить код повторно"
                }
            }
            timer.start()
        }
    }
}
