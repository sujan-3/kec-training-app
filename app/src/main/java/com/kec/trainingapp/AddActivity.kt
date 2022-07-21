package com.kec.trainingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.kec.trainingapp.data.MyItem
import com.kec.trainingapp.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener {
            val title = binding.titleEt.text.toString().trim()
            val desc = binding.descEt.text.toString().trim()

            val myItem = MyItem(1, title, desc, "http://goo.gl/gEgYUd")

            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "kec-db"
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

            db.myItemDao().add(myItem)
        }

    }
}