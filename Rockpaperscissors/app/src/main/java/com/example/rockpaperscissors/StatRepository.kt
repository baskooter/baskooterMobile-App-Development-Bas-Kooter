package com.example.rockpaperscissors

import android.content.Context

public class StatRepository(context: Context) {

    private var statDao: StatsDao

    init {
        val statRoomDatabase = StatsRoomDatabase.getDatabase(context)
        statDao = statRoomDatabase!!.statDao()
    }

    suspend fun getAllStat(): List<Stats> {
        return statDao.getAllStats()
    }

    suspend fun insertStat(stat: Stats) {
        statDao.insertStat(stat)
    }

    suspend fun deleteStat(stat: Stats) {
        statDao.deleteStat(stat)
    }

    suspend fun updateStat(stat: Stats) {
        statDao.updateStat(stat)
    }

    suspend fun countPlayerWin(): Int  {
        return statDao.countPlayerWin()
    }

    suspend fun countComputerWin() : Int {
        return statDao.countComputerWin()
    }

    suspend fun countDraw(): Int  {
        return statDao.countDraw()
    }



    suspend fun deleteAllStats() = statDao.deleteAllStats()

}
