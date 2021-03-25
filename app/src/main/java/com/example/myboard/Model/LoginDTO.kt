package com.example.myboard.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginDTO {
    @SerializedName("email")
    @Expose
    var email : String = ""

    @SerializedName("password")
    @Expose
    var password : String = ""

    @SerializedName("token")
    @Expose
    var token : String = ""

}