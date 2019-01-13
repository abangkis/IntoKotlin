package net.mreunionlabs.intokotlin.room

import net.mreunionlabs.intokotlin.room.entity.ItemInDb

interface ItemInDbRepository {
    fun getInDb(): ItemInDb?
}

class ItemInDbRepositoryImpl(private val db: AppDatabase) : ItemInDbRepository {

    // remember room cannot run in main thread, this is only an example
    // use coroutine for actual implementation
    override fun getInDb(): ItemInDb? {
        return db.itemInDbDao().getByName("Hello")
    }
}