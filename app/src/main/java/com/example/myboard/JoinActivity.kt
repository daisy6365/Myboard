package com.example.myboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_join.*

class JoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)


        val join_email = join_email.text.toString()
        val join_password = join_password.text.toString()
        val join_name = join_name.text.toString()
        val join_nickname = join_nickname.text.toString()

        join_btn.setOnClickListener {
            
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}














