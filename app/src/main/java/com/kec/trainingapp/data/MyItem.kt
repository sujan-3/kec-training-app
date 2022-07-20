package com.kec.trainingapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyItem(
    @PrimaryKey val id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val desc: String,
    @ColumnInfo val icon: String
)
