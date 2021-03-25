package com.example.myboard.Model

import android.provider.ContactsContract
import java.io.Serializable
import java.net.URL

class PostDTO (
        val name: String = "",
        var title: String = "",
        var content: String = "",
        var photos: ArrayList<Photo>,
        var likes: Int = 0,
        var comment_name : String = "",
        var comment : String = ""
)

data class Photo(
        var date_token : String,
        var url : URL
)