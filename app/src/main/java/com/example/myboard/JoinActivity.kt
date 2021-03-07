package com.example.myboard

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_join.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity() {
    val PREFERENCE = "data"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        SharedPreference.openSharedPrepJoin(this)
        join_btn.setOnClickListener {
            // 이메일, 비밀번호, 이름, 닉네임 서버로 보내기
            // Client.object에 xml id 연결하기 -> 서버에 보내줌
            Client.retrofitService.requestJoin(join_email.text.toString(), join_password.text.toString(), join_name.text.toString(), join_nickname.text.toString())
                .enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                    when (response!!.code()) {
                        //회원가입 성공
                        200 -> {
                            // SharedPreference를 이용해서 데이터 디바이스에 저장
                            // 나중에 회원정보 수정, 글 등록, 다른 유저와 채팅시 회원 정보 필요
                            val sharedPreference = getSharedPreferences(PREFERENCE, 0)
                            val editor = sharedPreference.edit()
                            editor.putString("id", join_email.text.toString())
                            editor.putString("pw", join_password.text.toString())
                            editor.putString("nickname", join_nickname.text.toString())

                            //Shared에 변동 사항 저장
                            editor.apply()
                            Toast.makeText(this@JoinActivity, "회원가입 성공", Toast.LENGTH_LONG).show()
                            finish ()

                            //화면 전환
                            startActivity(Intent(this@JoinActivity, LoginActivity::class.java))
                        }
                        // 회원가입 실패
                        405 -> Toast.makeText(this@JoinActivity, "회원가입 실패 : 아이디나 비번이 올바르지 않습니다", Toast.LENGTH_LONG).show()
                        500 -> Toast.makeText(this@JoinActivity, "회원가입 실패 : 서버 오류", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Void>?, t: Throwable?) {

                }


            })
        }
    }

}










