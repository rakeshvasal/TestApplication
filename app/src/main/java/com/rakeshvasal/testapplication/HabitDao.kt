package com.rakeshvasal.testapplication

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface HabitDao {

    @Insert
    fun insertHabit(habit: Habit)

    @Query("DELETE FROM HabitTable")
    fun deleteHabit()

    @Query("SELECT * FROM HabitTable ORDER BY habit asc")
    fun getAllHabits(): List<Habit>
}