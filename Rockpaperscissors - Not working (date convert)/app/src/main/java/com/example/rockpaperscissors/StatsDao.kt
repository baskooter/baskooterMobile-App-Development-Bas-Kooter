package com.example.rockpaperscissors

import androidx.room.*

@Dao
interface StatsDao {

    @Query("SELECT * FROM statTable")
    suspend fun getAllStats(): List<Stats>

    @Insert
    suspend fun insertStat(stat: Stats)

    @Delete
    suspend fun deleteStat(stat: Stats)

    @Update
    suspend fun updateStat(stat: Stats)

    @Query("SELECT COUNT(winnaar) FROM statTable WHERE winnaar = 'Player wins!'")
    suspend fun countPlayerWin() : Int

    @Query("SELECT COUNT(winnaar) FROM statTable WHERE winnaar = 'Computer wins!'")
    suspend fun countComputerWin(): Int

    @Query("SELECT COUNT(winnaar) FROM statTable WHERE winnaar = 'Draw!'")
    suspend fun countDraw(): Int

    @Query("DELETE FROM statTable")
    suspend fun deleteAllStats()
}
