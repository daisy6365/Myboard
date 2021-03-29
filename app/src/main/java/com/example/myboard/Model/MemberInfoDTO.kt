package com.example.myboard.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MemberInfoDTO {


    @SerializedName("d")
    @Expose
    val profile_img: String = ""

    @SerializedName("name")
    @Expose
    val name: String = ""

    @SerializedName("email")
    @Expose
    var email: String = ""

    @SerializedName("email")
    @Expose
    var password: String = ""
}
