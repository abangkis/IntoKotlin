package net.mreunionlabs.intokotlin.language2

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import net.mreunionlabs.intokotlin.R

import kotlinx.android.synthetic.main.activity_val_var.*

class ValVarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_val_var)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    data class Color(val name: String, var hex: String)

    fun valVar(){
        val black = Color("Black", "#000000")
        val white = Color("White", "#FFFFFF")

        val myColor = black
//        myColor = white;

        myColor.hex = "#FFFFFF"
    }

    fun nullSafety1(){
        var a: String = "abc"
//        a = null // compilation error

        var b: String? = "abc"
        b = null // ok
        print(b)
    }

    fun checkingForNull() {
        val b = "Kotlin"
        val l = if (b != null) b.length else -1

        // safe call operator
        val a = "Kotlin"
        val bb: String? = null
        println(bb?.length)
        println(a?.length)

        // chaining
//        bob?.department?.head?.name
    }

    fun letOperator() {
        val listWithNulls: List<String?> = listOf("Kotlin", null)
        for (item in listWithNulls) {
            item?.let { println(it) } // prints A and ignores null
        }
    }

    private fun printThis(item: String?) {
        item?.let {
            println(it)
        }
    }

    fun elvisOperator(){
        val b = "Kotlin"
        val l: Int = if (b != null) b.length else -1

        val l2 = b?.length ?: -1
        // If the expression to the left of ?: is not null, the elvis operator returns it, otherwise it returns the expression to the right
    }

    fun npeLovers() {
        val b : String?= null

        val l = b!!.length // throw NPE if b is null
    }
}
