package com.example.myboard

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//서버로 전달
interface LoginService {

    @FormUrlEncoded
    @POST("/app_login/")
    fun requestLogin(
        //로그인시 전달 값
        @Field("useremail") useremail:String,
        @Field("userpw") userpw:String
    ): Call<LoginServer>

}