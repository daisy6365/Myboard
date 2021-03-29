package com.example.myboard.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ChatModel {
    @SerializedName("name")
    @Expose
    var name: String = ""

    @SerializedName("content")
    @Expose
    var content:String = ""

    @SerializedName("image")
    @Expose
    var profile_image:String = ""


    // 프로필 사진이랑 시간 보내줄 것인지
}