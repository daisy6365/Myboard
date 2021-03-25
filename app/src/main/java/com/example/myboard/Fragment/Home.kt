package com.example.myboard.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.myboard.Activity.ClubActivity
import com.example.myboard.Activity.FoodActivity
import com.example.myboard.Activity.FreeActivity
import com.example.myboard.Activity.JobActivity
import com.example.myboard.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // 완벽한 서버통신(json, 요청)을위한 자료찾기
    // 채팅, 알림, 글등록, 댓글, 회원정보 수정 기능 구현(로그아웃, 회원탈퇴)
    // 각 기능 때 마다 서버로부터 회원정보 받기

    // API 서버 정보
    // 글 등록 :
    // 댓글 :
    // 채팅 :
    // 알림 :
    // 회원정보 수정 :
    // 채팅 -> 웹소켓 사용

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Life_cycle","onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        //Activity의 Oncreate에서 했던 작업을 여기에서 한다
        //작업들이 주로 여기서 일어남
        //자유게시판 클릭 -> 이동
        val free_board : LinearLayout = view.findViewById(R.id.free_board)
        free_board.setOnClickListener {
            activity?.let{
                val intent = Intent(context, FreeActivity::class.java)
                startActivity(intent)
            }
        }

        val job_board : LinearLayout = view.findViewById(R.id.job_board)
        job_board.setOnClickListener {
            activity?.let{
                val intent = Intent(context, JobActivity::class.java)
                startActivity(intent)
            }
        }

        val club_board : LinearLayout = view.findViewById(R.id.club_board)
        club_board.setOnClickListener {
            activity?.let{
                val intent = Intent(context, ClubActivity::class.java)
                startActivity(intent)
            }
        }

        val food_board : LinearLayout = view.findViewById(R.id.food_board)
        food_board.setOnClickListener {
            activity?.let{
                val intent = Intent(context, FoodActivity::class.java)
                startActivity(intent)
            }
        }



    }



}