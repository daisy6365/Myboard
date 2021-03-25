package com.example.myboard.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
//import com.example.myboard.Adapter.PostAdapter
import com.example.myboard.Client
import com.example.myboard.Model.PostListDTO
import com.example.myboard.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FreeActivity : AppCompatActivity() {
    private val TAG = FreeActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        // 제목, 내용, 글쓴이(name), 좋아요 수 , 댓글 수


        Client.retrofitService.requestAllData()
                .enqueue(object : Callback<PostListDTO>{
                    override fun onResponse(call: Call<PostListDTO>, response: Response<PostListDTO>) {
                        if (response.isSuccessful) {
                            val body = response.body()
                            body?.let {
                                //text_text.text = body.toString response 잘 받아왔는지 확인.
                            }
                        }
                    }

                    override fun onFailure(call: Call<PostListDTO>, t: Throwable) {
                        Log.d(TAG,"Post data 에러")
                    }
                })


    }
    //private fun setAdapter(photoList : ArrayList<Photo>){
    //        val mAdapter = PostAdapter(photoList,this)
    //        free_board_recycler.adapter = mAdapter
    //        free_board_recycler.layoutManager = LinearLayoutManager(this)
    //    }

}
