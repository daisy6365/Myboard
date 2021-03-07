package com.example.myboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.myboard.Adapter.MainFragmentAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BottomTabNavigation()
    }
    private fun BottomTabNavigation() {
        view_pager.adapter = MainFragmentAdapter(supportFragmentManager, 4)
        // tablayout과 viewpager를 연결
        bottom_tab.setupWithViewPager(view_pager)

        //activity_main.xml에 있는 탭 레이아웃에 커스텀한 하단탭바 뷰를 사용
        val bottomTabLayout : View = this.layoutInflater.inflate(R.layout.activity_bottom_tab, null, false)

        //각 탭에 맞는 버튼들을 일일히 다 연결
        bottom_tab.getTabAt(0)!!.customView = bottomTabLayout.findViewById(R.id.home_tab) as RelativeLayout
        bottom_tab.getTabAt(1)!!.customView = bottomTabLayout.findViewById(R.id.msg_tab) as RelativeLayout
        bottom_tab.getTabAt(2)!!.customView = bottomTabLayout.findViewById(R.id.alarm_tab) as RelativeLayout
        bottom_tab.getTabAt(3)!!.customView = bottomTabLayout.findViewById(R.id.mypage_tab) as RelativeLayout

    }
}

