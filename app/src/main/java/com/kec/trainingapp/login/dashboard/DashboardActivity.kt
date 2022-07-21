package com.kec.trainingapp.login.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kec.trainingapp.AddActivity
import com.kec.trainingapp.MyItemClickListener
import com.kec.trainingapp.R
import com.kec.trainingapp.data.MyItem
import com.kec.trainingapp.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding

    var myItems = mutableListOf<MyItem>()

    lateinit var myItemAdapter: MyItemAdapter

    val itemClickListener = object : MyItemClickListener {
        override fun onItemClick(myItem: MyItem) {
            Log.d("MainActivity", myItem.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.layoutManager = LinearLayoutManager(this)
        myItemAdapter = MyItemAdapter(myItems, this@DashboardActivity, itemClickListener)
        binding.rv.adapter = myItemAdapter

        binding.fab.setOnClickListener {
            val goToAddActivity = Intent(this@DashboardActivity, AddActivity::class.java)
            startActivity(goToAddActivity)
        }
    }
}

class MyItemAdapter(
    val items: MutableList<MyItem>,
    val context: Context,
    val listener: MyItemClickListener
) :
    RecyclerView.Adapter<MyItemAdapter.MyItemViewHolder>() {

    class MyItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTv: TextView
        val descTv: TextView
        val icon: ImageView
        val button: ImageButton

        init {
            titleTv = view.findViewById(R.id.title_tv)
            descTv = view.findViewById(R.id.desc_tv)
            icon = view.findViewById(R.id.iv)
            button = view.findViewById(R.id.btn)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemViewHolder {
        return MyItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyItemViewHolder, position: Int) {
        val myItem = items[position]

        holder.titleTv.setText(myItem.title)

        holder.descTv.setText(myItem.desc)

        Log.d("MyItemAdapter", "URL: " + myItem.icon)

        Glide.with(context).load(myItem.icon).into(holder.icon)

        holder.button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("MyItemAdapter", "onClick() " + myItem.desc)

                Toast.makeText(context, myItem.desc, Toast.LENGTH_SHORT).show()
            }
        })

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                listener.onItemClick(myItem)
            }
        })

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addData(myItem: MyItem) {
        items.add(myItem)

        notifyItemInserted(items.size - 1)
    }

}



