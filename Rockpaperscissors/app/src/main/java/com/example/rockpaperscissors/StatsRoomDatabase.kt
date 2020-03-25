package com.example.rockpaperscissors

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase




@Database(entities = [Stats::class], version = 1, exportSchema = false)

abstract class StatsRoomDatabase : RoomDatabase() {

    abstract fun statDao(): StatsDao

    companion object {
        private const val DATABASE_NAME = "STAT_DATABASE"

        @Volatile
        private var statsRoomDatabaseInstance: StatsRoomDatabase? = null

        fun getDatabase(context: Context): StatsRoomDatabase? {
            if (statsRoomDatabaseInstance == null) {
                synchronized(StatsRoomDatabase::class.java) {
                    if (statsRoomDatabaseInstance == null) {
                        statsRoomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            StatsRoomDatabase::class.java, DATABASE_NAME
                        )

                            .build()
                    }
                }
            }
            return statsRoomDatabaseInstance
        }
    }

}

