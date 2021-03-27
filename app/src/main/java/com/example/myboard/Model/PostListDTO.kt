package com.example.myboard.Model

import android.provider.ContactsContract
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URL

class PostListDTO {

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
