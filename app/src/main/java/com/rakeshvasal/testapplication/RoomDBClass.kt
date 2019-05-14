package com.rakeshvasal.testapplication

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Habit::class], version = 1)
abstract class RoomDBClass : RoomDatabase() {

    abstract val habitDao: HabitDao

    companion object {
        var Instance: RoomDBClass? = null

        fun getDatabaseObject(context: Context): RoomDBClass? {

            if (Instance == null) {
                synchronized(RoomDBClass::class) {
                    Instance = Room.databaseBuilder(context.applicationContext, RoomDBClass::class.java, "RoomDb").build()
                }
            }
            return Instance
        }

        fun destroyInstance() {
            Instance = null
        }
    }
}