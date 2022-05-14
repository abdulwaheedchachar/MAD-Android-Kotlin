package com.example.madlibs_storygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    fun makeStory(view: View){
        val intent : Intent = Intent(this,StoryActivity::class.java)
        startActivity(intent)
    }

}