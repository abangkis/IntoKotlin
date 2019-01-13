package net.mreunionlabs.intokotlin.language

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_copy.*
import net.mreunionlabs.intokotlin.R
import net.mreunionlabs.intokotlin.adapter.KotlinAdapter
import net.mreunionlabs.intokotlin.adapter.KotlinItem

class PasteKotlinActivity : AppCompatActivity() {

    private lateinit var adapter: KotlinAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_copy)
        initActionToolbar()

        initRecyclerView()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun initActionToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setNavigationIcon(R.mipmap.ic_launcher)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = getString(R.string.app_name)
        }
    }

    private fun initRecyclerView() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = KotlinAdapter(
            mutableListOf(
                KotlinItem("Title 1", "Content Number 1"),
                KotlinItem("Title 2", "Content 2")
            )
        ) { item -> onItemClick(item) }
        recyclerView.adapter = adapter

//        recyclerView.addOnItemTouchListener(
//            RecyclerItemClickListener(applicationContext,
//                RecyclerItemClickListener.OnItemClickListener { view, position ->
//                    val item = adapter!!.getItem(position)
//
//                    val i = Intent(applicationContext, NextActivity::class.java)
//                    i.putExtra("title", item.title)
//                    startActivity(i)
//                })
//        )
    }

    private fun onItemClick(item: KotlinItem) {
        Log.d("Paste kotlin", "item ${item.title} clicked ")
    }

}
