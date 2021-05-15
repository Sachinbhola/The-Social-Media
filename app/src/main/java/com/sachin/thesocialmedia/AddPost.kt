package com.sachin.thesocialmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sachin.thesocialmedia.daos.PostDao
import com.sachin.thesocialmedia.daos.UserDao
import kotlinx.android.synthetic.main.activity_add_post.*

class AddPost : AppCompatActivity() {

    private lateinit var postDao : PostDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        btnAddPost.setOnClickListener{
            val input= this.etPost.text.toString().trim()

            postDao = PostDao()
            if(input.isNotEmpty()){
                postDao.addPost(input)
                finish()
            }
            else{
                val toast = Toast.makeText(applicationContext,"Enter text", Toast.LENGTH_LONG)
                toast.show()
            }

        }
    }
}