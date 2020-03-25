package com.example.rockpaperscissors

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*


@Entity(tableName = "statTable")
@Parcelize
data class Stats (
    @ColumnInfo(name = "date")
    val date: Date?,
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