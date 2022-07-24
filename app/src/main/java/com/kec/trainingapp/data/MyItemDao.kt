package com.kec.trainingapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyItemDao {
    @Insert
    fun add(myItem: MyItem)

    @Query("SELECT * FROM MyItem")
    fun fetchAllItems(): MutableList<MyItem>
}