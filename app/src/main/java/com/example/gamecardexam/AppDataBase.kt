package com.example.gamecardexam

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 6)
abstract class AppDataBase : RoomDatabase() {

    abstract fun itemDao() : ItemDao

}