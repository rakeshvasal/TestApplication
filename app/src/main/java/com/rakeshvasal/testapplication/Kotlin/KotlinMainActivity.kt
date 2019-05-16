package com.rakeshvasal.testapplication.Kotlin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.rakeshvasal.testapplication.R

class KotlinMainActivity : AppCompatActivity() {

    private var roomDBClass: RoomDBClass? = null
    val NEW_WORD_ACTIVITY_REQUEST_CODE = 1
    private var newHabitViewModel: HabitViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main)

        newHabitViewModel = ViewModelProviders.of(this, HabitViewModelFactory(application)).get(HabitViewModel::class.java)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val adapter = HabitListAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        //val habit = Habit("Rakesh")

        //newHabitViewModel?.insert(habit)

        newHabitViewModel?.allWords?.observe(this, object : Observer<List<Habit>> {
            override fun onChanged(t: List<Habit>?) {
                adapter.setWords(t!!)
            }
        })

    }
}
