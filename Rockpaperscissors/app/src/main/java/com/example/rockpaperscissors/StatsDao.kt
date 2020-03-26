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


    @Query("DELETE FROM statTable")
    suspend fun deleteAllStats()

    @Query("SELECT COUNT(*) FROM statTable WHERE winnaar like :resultString")
    suspend fun getResultCount(resultString: String?): Int
}
