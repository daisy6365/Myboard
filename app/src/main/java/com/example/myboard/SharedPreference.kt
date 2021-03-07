package com.example.myboard

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
// 로그인시 계정 정보를 저장해놓고 출력할 수 있음
// 데이터 영구 저장 (디바이스에 저장)
// Context.getSharedPreferences(String, int) -> data returned
object SharedPreference {
    val LOGIN_SESSION = "login.session"
    val JOIN_SESSION = "join.session"

    private var sharedPrefLogin: SharedPreferences? = null
    private var sharedPrefJoin: SharedPreferences? = null

    //로그인할
    fun openSharedPrepLogin(context: Context) {
        this.sharedPrefLogin = context.getSharedPreferences(LOGIN_SESSION, 0)
    }

    //회원가입할때
    fun openSharedPrepJoin(context: Context) {
        this.sharedPrefJoin = context.getSharedPreferences(JOIN_SESSION, 0)
    }
    fun writeLoginSession(data: String) {
        if(this.sharedPrefLogin == null) {
            Log.e("DSMAD", "Plz start openSahredPrep() !")
        } else {
            sharedPrefLogin?.edit()?.putString("session", data)?.apply()
        }
    }

    fun readLoginSession() : String? {
        return if(this.sharedPrefLogin == null) {
            Log.e("DSMAD", "Plz start openSahredPrep() !")
            null
        } else sharedPrefLogin?.getString("session", null)
    }
}
