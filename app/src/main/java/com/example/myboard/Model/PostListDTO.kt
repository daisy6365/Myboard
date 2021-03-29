package com.example.myboard.Model

import android.provider.ContactsContract
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URL

class PostListDTO {
    //SawggerUI보니까 보내주는 값이 다른것같음
    //내가 무엇을 보내줘야하는지 -> 토큰만?
    // 그리고 게시판종류마다 글도 다를텐데 어떻게 대처?
    
    @SerializedName("title")
    @Expose
    var title: String = ""

    @SerializedName("writer")
    @Expose
    var content: String = ""

    @SerializedName("commentCount")
    @Expose
    var like_count: Int = 0

    @SerializedName("commentCount")
    @Expose
    var comment_count : String = ""
}
