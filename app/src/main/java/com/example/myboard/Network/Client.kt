package com.example.myboard.Network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Client {
    private val TAG = Client::class.java.simpleName
    var retrofitService : InfoService

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val logger =
            OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS).build()

        //Todo 서버주소 입력하기
        // 서비스 만듦
        val retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-79-194-161.ap-northeast-2.compute.amazonaws.com:8080/")
                //Gson은 Json문서를 받아서 자동으로 java class 형태로 만들어주는 역할
            .addConverterFactory(GsonConverterFactory.create())
            .client(logger)
            .build()

        retrofitService = retrofit.create(InfoService::class.java)
        Log.d(TAG, "서버 연결")
    }

}