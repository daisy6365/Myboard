package com.example.myboard

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Client {
    var retrofitService : InfoService

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val logger =
            OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS).build()

        //Todo 서버주소 입력하기
        // 서비스 만듦
        val retrofit = Retrofit.Builder()
            .baseUrl("https://서버주소입력하기")
            .addConverterFactory(GsonConverterFactory.create())
            .client(logger)
            .build()

        retrofitService = retrofit.create(InfoService::class.java)
    }

}