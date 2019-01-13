package net.mreunionlabs.intokotlin.usingkoin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_using_koin.*
import net.mreunionlabs.intokotlin.R
import org.koin.android.viewmodel.ext.android.viewModel

class UsingKoinActivity : AppCompatActivity() {

    private val vm by viewModel<UsingKoinVm>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_using_koin)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            Log.d("USING KOIN", vm.getHello())
        }


    }

}
