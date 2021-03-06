package com.rakeshvasal.testapplication.Kotlin

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

class HabitRepository(application: Application) {

    private val habitDao : HabitDao
    private val listLiveData: LiveData<List<Habit>>

    init {
        val habitRoomDatabase = RoomDBClass.getDatabaseObject(application)
        habitDao = habitRoomDatabase?.habitDao()!!
        listLiveData = habitDao?.getAllHabits()
    }


    fun getAllHabits(): LiveData<List<Habit>> {
        return listLiveData
    }

    fun insert(word: Habit) {
        InsertAsyncTask(habitDao).execute(word)
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: HabitDao) : AsyncTask<Habit, Void, Void>() {

        override fun doInBackground(vararg params: Habit): Void? {
            mAsyncTaskDao.insertHabit(params[0])
            return null
        }
    }
}