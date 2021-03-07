package com.example.myboard

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    val PREFERENCE = "data"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        SharedPreference.openSharedPrepLogin(this)
        email_login_btn.setOnClickListener {
            Client.retrofitService.requestLogin(login_email.text.toString(), login_password.text.toString()).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                    when (response!!.code()) {
                        200 -> {
                            val sharedPreference = getSharedPreferences(PREFERENCE, 0)
                            val editor = sharedPreference.edit()

                            //로그인시 디바이스에 데이터 저장
                            editor.putString("id", login_email.text.toString())
                            editor.putString("pw", login_password.text.toString())
                            //Shared에 변동사항 저장
                            editor.apply()
                            finish()

                            //메인화면으로 전환
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        }
                        405 -> Toast.makeText(this@LoginActivity, "로그인 실패 : 아이디나 비번이 올바르지 않습니다", Toast.LENGTH_LONG).show()
                        500 -> Toast.makeText(this@LoginActivity, "로그인 실패 : 서버 오류", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Void>?, t: Throwable?) {

                }


            })
        }

        log_join_btn.setOnClickListener { startActivity(Intent(this@LoginActivity, JoinActivity::class.java)) }
    }
}