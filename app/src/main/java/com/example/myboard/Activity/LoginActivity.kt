package com.example.myboard.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myboard.Client
import com.example.myboard.Model.LoginDTO
import com.example.myboard.R
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private val TAG = LoginActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var email = ""
        var password = ""
        lateinit var token : String


//        SharedPreference.openSharedPrepLogin(this)
        email_login_btn.setOnClickListener {
            email = login_email.text.toString()
            password = login_password.text.toString()

            val paramObject = JsonObject()
            paramObject.addProperty("email", email)
            paramObject.addProperty("password", password)

            Client.retrofitService.requestLogin(paramObject)
                    .enqueue(object : Callback<LoginDTO> {
                override fun onResponse(call: Call<LoginDTO>, response: Response<LoginDTO>) {
                    if (response.isSuccessful) {
                        token = response.body()!!.token
                        //token 저장
                          val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
                          val editor = sp.edit()
                          editor.putString("login_token", token)
                          editor.commit()

                        Log.d(TAG, "로그인 성공")
                        Toast.makeText(this@LoginActivity, "로그인에 성공하였습니다.", Toast.LENGTH_LONG).show()
                        //메인화면으로 전환
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)

                        startActivity(intent)
                        finish()
                    }
                }

                override fun onFailure(call: Call<LoginDTO>?, t: Throwable?) {
                    Log.d(TAG, "로그인 실패")
                    Toast.makeText(this@LoginActivity, "로그인 실패", Toast.LENGTH_LONG).show()
                }


            })
        }

        log_join_btn.setOnClickListener {
            startActivity(Intent(this@LoginActivity, JoinActivity::class.java))
        }
    }
}