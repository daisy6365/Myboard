package com.example.myboard.Network

import com.example.myboard.Model.LoginDTO
import com.example.myboard.Model.PostListDTO
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

//서버로 전달
interface InfoService {

    // Todo POST에 서버와 통신하기위한 값 적기
    // @Json 방식 말고 class 형태로 받아야함 -> DTO 필요


    @Headers("Content-Type: application/json; charset=UTF-8")
    @POST("/members/login")
    abstract fun requestLogin(
        //로그인시 전달 값
        @Body body : JsonObject
    ): Call<LoginDTO>
    // <> 안에 요청안에 데이터 or 응답에 대한 매핑

    //Todo POST에 서버와 통신하기위한 값 적기
    @Headers("Content-Type: application/json; charset=UTF-8")
    @POST("/members")
    abstract fun requestJoin(
        //회원가입시 전달 값
        @Body body : JsonObject
    ): Call<Unit>


    @GET("/categories/{categoryId}/posts")
    abstract fun requestAllData(
            @Header("X-AUTH-TOKEN") userToken : String
    ) : Call<PostListDTO>

}

