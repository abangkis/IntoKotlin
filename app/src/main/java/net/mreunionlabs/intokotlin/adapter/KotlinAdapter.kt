package net.mreunionlabs.intokotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_item.view.*
import net.mreunionlabs.intokotlin.R
import net.mreunionlabs.intokotlin.extensions.inflate

data class KotlinItem(val title: String, val content: String)

// To implement listener, traditionally we would have implemented this with an Interface and Listeners.
//  In Kotlin, you can greatly simplify the code through function parameters and lambda expressions.

class KotlinAdapter(private val items: MutableList<KotlinItem>, private val listener: (KotlinItem) -> Unit) :
    RecyclerView.Adapter<KotlinAdapter.ViewHolder>() {

    //    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), LayoutContainer {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bind(item: KotlinItem, listener: (KotlinItem) -> Unit) {
            itemView.txtTitle.text = item.title
            itemView.txtContent.text = item.title
            itemView.setOnClickListener{listener(item)} // pass lambda to the set onclick listener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.card_item))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount() = items.size

    fun getItem(position: Int) = items[position]
}