package com.example.myboard.Model

import android.provider.ContactsContract
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URL

class PostListDTO {
    @SerializedName("writer")
    @Expose
    val name: String = ""

    @SerializedName("title")
    @Expose
    var title: String = ""

    @SerializedName("email")
    @Expose
    var content: String = ""

    @SerializedName("email")
    @Expose
    var like_count: Int = 0

    @SerializedName("commentCount")
    @Expose
    var comment_count : String = ""
}
