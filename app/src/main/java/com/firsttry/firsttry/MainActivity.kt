package com.firsttry.firsttry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log

val loginPairList = listOf<Pair<String, String>> ("Andrey" to "123", "Sergey" to "456", "Ivan" to "789")

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signInButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            Log.d("USER", "$username")
            Log.d("PASS", "$password")

            if (loginPairList.contains(username to password)){
                val intent = Intent(this, VerifyActivity::class.java)
                finish()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Неверно введен логин/пароль $username $password", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        resetPassText.setOnClickListener{
            val intent = Intent(this, RecoverActivity::class.java)
            startActivity(intent)
        }
    }
}