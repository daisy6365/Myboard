package com.example.myboard.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostWriteDTO {
    //게시글뷰 말고 쓰는뷰일때도 사진을 리스트뷰를 보낼것인지

    @SerializedName("title")
    @Expose
    var title : String = ""

    @SerializedName("content")
    @Expose
    var content : String = ""

    @SerializedName("photos")
    @Expose
    val photos: List<String> = listOf()
}