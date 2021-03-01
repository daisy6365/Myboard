package com.example.myboard

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    var loginServer:LoginServer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //TODO 로그인 url 바꾸기
        var retrofit = Retrofit.Builder()
            .baseUrl("http://220.85.200.219")
            .addConverterFactory(GsonConverterFactory.create())
                //Json 문서를 받아서 자동으로 class 형태로 만들어줌
            .build()

        var loginService : LoginService = retrofit.create(LoginService :: class.java)

        email_login.setOnClickListener {
            var login_email = login_email.text.toString()
            var login_password = login_password.text.toString()

            loginService.requestLogin(login_email,login_password).enqueue(object : Callback<LoginServer>{
                override fun onFailure(call: Call<LoginServer>, t: Throwable) {
                    Log.e("LOGIN", t.message.toString())
                    var dialog = AlertDialog.Builder(this@LoginActivity)
                    dialog.setTitle("에러")
                    dialog.setMessage("호출실패했습니다.")
                    dialog.show()

                }

                override fun onResponse(call: Call<LoginServer>, response: Response<LoginServer>) {
                    loginServer = response.body()
                    // TODO 나중에 바꾸기
                    Log.d("LOGIN","msg : "+loginServer?.msg)
                    Log.d("LOGIN","code : "+loginServer?.code)
                    var dialog = AlertDialog.Builder(this@LoginActivity)
                    dialog.setTitle(loginServer?.msg)
                    dialog.setMessage(loginServer?.code)
                    dialog.show()

                }
            })
        }
        //회원가입
        log_join_btn.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }


    }
}