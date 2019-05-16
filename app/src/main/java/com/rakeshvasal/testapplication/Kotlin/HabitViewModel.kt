package com.rakeshvasal.testapplication.Kotlin

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

class HabitViewModel(application: Application) : AndroidViewModel(application) {

    private val habitRepository: HabitRepository
    internal val allWords: LiveData<List<Habit>>

    init {
        habitRepository = HabitRepository(application)
        allWords = habitRepository.getAllHabits()
    }

    fun insert(habits: Habit) {
        habitRepository.insert(habits)
    }
}