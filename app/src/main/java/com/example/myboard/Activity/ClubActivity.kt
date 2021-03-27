package com.example.myboard.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myboard.Adapter.PostAdapter
import com.example.myboard.Client
import com.example.myboard.Model.PostListDTO
import com.example.myboard.R
import kotlinx.android.synthetic.main.activity_board.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClubActivity : AppCompatActivity() {
    private val TAG = FreeActivity::class.java.simpleName
    //lateinit var glide: RequestManager

    val PREFERENCE = "SharedPreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        //게시판 제목 변경 -> 동아리게시판
        board_title.text = "동아리 게시판"

        var pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE)
        var token:String = pref.getString("userToken", "").toString()


        //이미지 첨부시 glide 사용
        //glide = Glide.with(this)


        // 제목, 내용, 글쓴이(name), 좋아요 수 , 댓글 수
        Client.retrofitService.requestAllData(token)
                .enqueue(object : Callback<PostListDTO> {
                    override fun onResponse(call: Call<PostListDTO>, response: Response<PostListDTO>) {
                        if (response.isSuccessful) {
                            Log.d(TAG,"PostList retrofit 성공")
                            val postList = response.body()
                            //text_text.text = body.toString response 잘 받아왔는지 확인.

                            val adapter = PostAdapter()
                            //glide (이미지 첨부시)


                            board_recycler.adapter = adapter
                            board_recycler.layoutManager = LinearLayoutManager(this@ClubActivity)

                        }
                    }
                    override fun onFailure(call: Call<PostListDTO>, t: Throwable) {
                        Log.d(TAG,"Post data 에러")
                    }
                })

        writeicon.setOnClickListener {
            val postWritingintent = Intent(this@ClubActivity, PostWritingActivity::class.java)
            startActivity(postWritingintent)
        }

    }
}
