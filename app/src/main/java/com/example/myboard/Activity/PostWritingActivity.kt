package com.example.myboard.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myboard.R
import kotlinx.android.synthetic.main.activity_postwriting.*

class PostWritingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postwriting)

        var title = writing_title.text.toString()
        var content = writing_content.text.toString()
        var photos : List<String>

        writing_btn.setOnClickListener {

        }


    }
}