package com.example.myboard.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.myboard.Fragment.Alarm
import com.example.myboard.Fragment.Chatting
import com.example.myboard.Fragment.Home
import com.example.myboard.Fragment.Mypage

class MainFragmentAdapter (fm : FragmentManager, val fragmentCount :Int ) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return Home()
            1 -> return Chatting()
            2 -> return Alarm()
            3 -> return Mypage()
            else -> return Home()
        }
    }

    override fun getCount(): Int = fragmentCount

}