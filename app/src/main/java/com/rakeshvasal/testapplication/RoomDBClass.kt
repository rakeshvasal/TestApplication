package com.rakeshvasal.testapplication

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import java.util.*

@Database(entities = [Habit::class], version = 1)
abstract class RoomDBClass : RoomDatabase() {

    abstract var habitDao: HabitDao

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

        var mRoomDataBaseCallback = object : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsync(Instance).execute()
            }
        }

        private class PopulateDbAsync(obj: RoomDBClass?) : AsyncTask<Void, Void, Void>() {

            val roomDbObj: RoomDBClass? = null
            var daoObj: HabitDao? = null

            init {
                daoObj = roomDbObj?.habitDao
            }

            override fun doInBackground(vararg p0: Void?): Void? {

                daoObj?.deleteHabit()
                val habit1 = Habit("Hello")
                daoObj?.insertHabit(habit1)
                val habit2 = Habit("World")
                daoObj?.insertHabit(habit2)
                return null
            }

        }
    }


}