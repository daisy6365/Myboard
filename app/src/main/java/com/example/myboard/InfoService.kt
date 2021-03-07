package com.example.myboard

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//서버로 전달
interface InfoService {

    @FormUrlEncoded
    //Todo POST에 서버와 통신하기위한 값 적기
    @POST("/app_login/")
    fun requestLogin(
        //로그인시 전달 값
        @Field("login_email") login_email:String,
        @Field("login_password") login_password:String
    ): Call<Void>

    @FormUrlEncoded
    //Todo POST에 서버와 통신하기위한 값 적기
    @POST("/app_join/")
    fun requestJoin(
        //회원가입시 전달 값
        @Field("join_email") join_email:String,
        @Field("join_password") join_password:String,
        @Field("join_name") join_name:String,
        @Field("join_nickname") join_nickname:String
    ): Call<Void>

}