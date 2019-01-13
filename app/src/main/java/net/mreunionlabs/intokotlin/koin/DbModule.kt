package net.mreunionlabs.intokotlin.koin

import android.arch.persistence.room.Room
import net.mreunionlabs.intokotlin.room.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val dbModule = module {
    // room
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "my_app.db").build()
    }
}
