package net.mreunionlabs.intokotlin.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import net.mreunionlabs.intokotlin.room.entity.ItemInDb

@Dao
interface ItemInDbDao : BaseDao<ItemInDb> {

    @Query("SELECT * FROM item_in_db WHERE name = :name")
    fun getByName(name: String): ItemInDb?
}