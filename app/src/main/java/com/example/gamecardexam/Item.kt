package com.example.gamecardexam

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "retry") val retry: Int
        )