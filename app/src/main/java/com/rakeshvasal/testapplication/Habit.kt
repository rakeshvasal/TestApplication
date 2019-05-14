package com.rakeshvasal.testapplication

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "HabitTable")
data class Habit(@PrimaryKey @ColumnInfo(name = "habit") var mHabit: String="")