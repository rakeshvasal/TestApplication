package com.rakeshvasal.testapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class KotlinMainActivity : AppCompatActivity() {

    private var roomDBClass: RoomDBClass? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main)

    }
}
