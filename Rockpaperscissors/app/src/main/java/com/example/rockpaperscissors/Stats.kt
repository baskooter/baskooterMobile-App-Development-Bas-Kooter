package com.example.rockpaperscissors

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize



@Entity(tableName = "statTable")
@Parcelize
data class Stats (
    @ColumnInfo(name = "date")
    val date: Long,
    @ColumnInfo(name = "winnaar")
    var winnaar: String,
    @ColumnInfo(name = "userHand")
    var userHand: String,
    @ColumnInfo(name = "computerHand")
    var computerHand: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

) : Parcelable