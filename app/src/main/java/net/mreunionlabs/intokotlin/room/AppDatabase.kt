package net.mreunionlabs.intokotlin.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import net.mreunionlabs.intokotlin.room.dao.ItemInDbDao
import net.mreunionlabs.intokotlin.room.entity.ItemInDb

@Database(
    entities = [
        ItemInDb::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun itemInDbDao(): ItemInDbDao

}