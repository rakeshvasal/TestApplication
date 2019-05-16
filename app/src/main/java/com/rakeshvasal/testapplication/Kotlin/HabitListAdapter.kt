package com.rakeshvasal.testapplication.Kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rakeshvasal.testapplication.R

class HabitListAdapter internal constructor(context: Context) : RecyclerView.Adapter<HabitListAdapter.HabitViewHolder>() {
    private val mInflater: LayoutInflater
    private var habitsList: List<Habit>? = null

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HabitViewHolder {

        val itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return HabitViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return if (habitsList != null) {
            habitsList!!.size
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        if (habitsList != null) {
            val (habit) = habitsList!!.get(position)
            holder.hbtextView.text = habit
        } else {
            holder.hbtextView.text = "No Word"
        }
    }

    internal fun setWords(habitsList: List<Habit>) {
        this.habitsList = habitsList
        notifyDataSetChanged()
    }


    inner class HabitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hbtextView: TextView

        init {
            hbtextView = itemView.findViewById(R.id.textView)
        }

    }
}