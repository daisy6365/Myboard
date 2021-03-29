package com.example.myboard.Fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myboard.R
import kotlinx.android.synthetic.main.fragment_mypage.*


class Mypage : Fragment() {
    var token: String? = null
    val PREFERENCE = "SharedPreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mypage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Life_cycle","onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        //SharedPreference로 해당 회원의 토큰값 가져오기
        val pref = this.activity!!.getSharedPreferences("pref", Context.MODE_PRIVATE)
        token = pref.getString("userToken", "").toString()
        change_password.setOnClickListener {

        }

        change_email.setOnClickListener {

        }
        change_profile_img.setOnClickListener {

        }


        logout.setOnClickListener {

        }
        delete_account.setOnClickListener {
            
        }


    }
}