package com.kec.trainingapp

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kec.trainingapp.data.MyItem
import com.kec.trainingapp.databinding.ActivityAddBinding
import com.kec.trainingapp.network.Api
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

            save(myItem)

          /*  val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "kec-db"
            )
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_2_3)
                .build()

            db.myItemDao().add(myItem)*/

            result = true
        }
    }

    private fun save(myItem: MyItem) {
        Api.apiService.save(myItem).enqueue(object: Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d("API" , " is successful: " + response.isSuccessful)
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("API" , " onFailure() " + t.localizedMessage)
            }

        })
    }

    override fun onBackPressed() {
        setResult(if (result) Activity.RESULT_OK else Activity.RESULT_CANCELED)
        finish()
    }
}