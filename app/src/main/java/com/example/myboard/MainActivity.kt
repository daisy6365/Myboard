package com.example.myboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_layout.addTab(tab_layout.newTab().setText("ALARM"))
        tab_layout.addTab(tab_layout.newTab().setText("HOME"))
        tab_layout.addTab(tab_layout.newTab().setText("MY PAGE"))

        val pagerAdapter = FragmentPagerAdapter(supportFragmentManager, 3)
        view_pager.adapter = pagerAdapter

        //tablelayout과 pager연결
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.setCurrentItem(tab!!.position)
            }
        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        // -> 페이져가 이동했을때 탭을 이동시키는 코드
    }
}

class FragmentPagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount: Int
) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        // 리턴 타입 -> Fragment
        // 포지션에 해당하는 fragment를 리턴해야함
        when (position) {
            0 -> {
                return ALARM()
            }
            1 -> {
                return HOME()
            }
            2 -> {
                return MYPAGE()
            }
            else -> return HOME()
        }

    }

    override fun getCount(): Int {
        // 전체 사이즈 리턴
        return tabCount
    }
}
