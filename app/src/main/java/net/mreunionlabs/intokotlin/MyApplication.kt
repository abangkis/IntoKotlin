package net.mreunionlabs.intokotlin

import android.app.Application
import net.mreunionlabs.intokotlin.koin.appModule
import net.mreunionlabs.intokotlin.koin.dbModule
import org.koin.android.ext.android.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // start Koin context
        startKoin(this, listOf(appModule, dbModule))
    }
}