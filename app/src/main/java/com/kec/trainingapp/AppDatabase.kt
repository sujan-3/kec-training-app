package com.kec.trainingapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kec.trainingapp.data.MyItem
import com.kec.trainingapp.data.MyItemDao

@Database(entities = [MyItem::class, ], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun myItemDao(): MyItemDao
}
