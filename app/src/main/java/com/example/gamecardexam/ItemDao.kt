package com.example.gamecardexam

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ItemDao {

    @Query("SELECT * FROM item_table")
    fun get(): List<Item>

    @Insert
    fun insert(item : Item)

    @Delete
    fun delete(item: Item)

   // @Query("SELECT * FROM ITEM_TABLE WHERE retry LIKE :categoryTry ")
    //fun find(categoryTry: Int) : List<Item>

}