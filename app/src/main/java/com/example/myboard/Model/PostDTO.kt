package com.example.myboard.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostDTO {
    //사진이 여러장이 첨부될수 있으므로 리스트 형태로 보내줄 것인지
    //토큰문제
    //Swagger보니까 좀 다른것같음

    @SerializedName("d")
    @Expose
    val profile_img: String = ""

    @SerializedName("email")
    @Expose
    val name: String = ""

    @SerializedName("email")
    @Expose
    var title: String = ""

    @SerializedName("email")
    @Expose
    var content: String = ""

    @SerializedName("email")
    @Expose
    val photos: List<String> = listOf()


    @SerializedName("email")
    @Expose
    var like_count: Int = 0

    @SerializedName("email")
    @Expose
    var comment_name : String = ""

    @SerializedName("commentCount")
    @Expose
    var comment : String = ""

    @SerializedName("commentCount")
    @Expose
    var comment_count : String = ""
}
