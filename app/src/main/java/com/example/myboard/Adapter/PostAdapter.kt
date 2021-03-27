package com.example.myboard.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myboard.Activity.PostActivity
import com.example.myboard.Model.PostListDTO
import com.example.myboard.R


class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private var dataList: ArrayList<PostListDTO> = ArrayList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postTitle: TextView
        val postContent: TextView
        val postLikeNum: TextView
        val postCommentNum: TextView
        val board_item: LinearLayout

        init {
            postTitle = itemView.findViewById(R.id.post_title)
            postContent = itemView.findViewById(R.id.post_text)
            postLikeNum = itemView.findViewById(R.id.like_num)
            postCommentNum = itemView.findViewById(R.id.comment_num)
            board_item = itemView.findViewById(R.id.board_item)
        }


    }

    //아이템 뷰로 사용 될 xml inflate 시킴
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.board_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    //뷰안에 필요한 정보 채움
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postTitle.setText(dataList.get(position).title)
        holder.postContent.setText(dataList.get(position).content)
        holder.postLikeNum.setText(dataList.get(position).like_count)
        holder.postCommentNum.setText(dataList.get(position).comment_count)
        //glide.load(postList.get(position).image).into(holder.postImage)

        holder.board_item.setOnClickListener(View.OnClickListener { v ->
            val intent = Intent(v.context, PostActivity::class.java)
            v.context.startActivity(intent)
        })

    }
}