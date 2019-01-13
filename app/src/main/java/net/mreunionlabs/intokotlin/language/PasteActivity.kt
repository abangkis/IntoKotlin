package net.mreunionlabs.intokotlin.language

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import net.mreunionlabs.intokotlin.R
import net.mreunionlabs.intokotlin.adapter.Item
import net.mreunionlabs.intokotlin.adapter.ItemAdapter
import net.mreunionlabs.intokotlin.recyclerview.RecyclerItemClickListener
import java.util.*

class PasteActivity : AppCompatActivity() {

    private val TAG = "CopyActivity"

    private var recyclerView: RecyclerView? = null
    private var adapter: ItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_copy)
        initActionToolbar()

        initRecyclerView()
        val items = ArrayList<Item>()
        val item = Item()
        item.title = "Title 1"
        item.content = "Content number 1"
        items.add(item)

        adapter = ItemAdapter(this, items)
        recyclerView!!.adapter = adapter


        val fab = findViewById<FloatingActionButton>(R.id.fab)
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
        recyclerView = findViewById(R.id.recyclerView)

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView!!.setHasFixedSize(true)

        recyclerView!!.layoutManager = LinearLayoutManager(this)

        recyclerView!!.addOnItemTouchListener(
            RecyclerItemClickListener(applicationContext,
                RecyclerItemClickListener.OnItemClickListener { view, position ->
                    val item = adapter!!.getItem(position)

                    val i = Intent(applicationContext, NextActivity::class.java)
                    i.putExtra("title", item.title)
                    startActivity(i)
                })
        )
    }

}
