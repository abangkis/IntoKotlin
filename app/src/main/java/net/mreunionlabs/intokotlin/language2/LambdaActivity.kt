package net.mreunionlabs.intokotlin.language2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import net.mreunionlabs.intokotlin.R

class LambdaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lambda)

        anonymousFunction({ a: Int, b: Int -> a + b })
    }

    fun anonymousFunction(function: (Int, Int) -> Int) {
        Log.d("LambdaActivity", "Calculation result: " + function(1, 2))
    }


}
