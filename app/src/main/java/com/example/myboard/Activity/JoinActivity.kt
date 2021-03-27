package com.example.myboard.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myboard.Client
import com.example.myboard.R
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_join.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity() {
    private val TAG = JoinActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        var email = ""
        var password = ""
        var name = ""

//      SharedPreference.openSharedPrepJoin(this)
        join_btn.setOnClickListener {
            email = join_email.text.toString()
            password = join_password.text.toString()
            name = join_name.text.toString()

            val paramObject = JsonObject()
            paramObject.addProperty("email", email)
            paramObject.addProperty("password", password)
            paramObject.addProperty("name", name)

            // 이메일, 비밀번호, 이름, 닉네임 서버로 보내기
            // Client.object에 xml id 연결하기 -> 서버에 보내줌
            Client.retrofitService.requestJoin(paramObject)
                    .enqueue(object : Callback<Unit> {
                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if (response.isSuccessful) {
                                Log.d(TAG, "회원가입 성공")
                                Toast.makeText(this@JoinActivity, "회원가입이 되었습니다. 다시 로그인해주세요.", Toast.LENGTH_LONG).show()
                                val intent = Intent(applicationContext, LoginActivity::class.java)
                                //화면 전환
                                startActivity(intent)
                                finish()
                            }
                            else{
                                Toast.makeText(this@JoinActivity, "회원가입 실패", Toast.LENGTH_LONG).show()
                            }

                        }
                        override fun onFailure(call: Call<Unit>?, t: Throwable?) {
                            Toast.makeText(this@JoinActivity, "회원가입 실패", Toast.LENGTH_LONG).show()
                        }
                    })
        }
    }

}










