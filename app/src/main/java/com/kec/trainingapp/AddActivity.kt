package com.kec.trainingapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kec.trainingapp.data.MyItem
import com.kec.trainingapp.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding

    val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                "ALTER TABLE MyItem "
                        + " ADD COLUMN rating INTEGER DEFAULT 0 NOT NULL"
            )
        }
    }

    var result = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener {
            val title = binding.titleEt.text.toString().trim()
            val desc = binding.descEt.text.toString().trim()

            val myItem = MyItem(0, title, desc, "http://goo.gl/gEgYUd", 5)

            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "kec-db"
            )
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_2_3)
                .build()

            db.myItemDao().add(myItem)

            result = true
        }
    }

    override fun onBackPressed() {
        setResult(if (result) Activity.RESULT_OK else Activity.RESULT_CANCELED)
        finish()
    }
}