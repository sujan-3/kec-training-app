package com.kec.trainingapp.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface MyItemDao {
    @Insert
    fun add(myItem: MyItem)
}