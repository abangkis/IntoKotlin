package net.mreunionlabs.intokotlin.room.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Update

interface BaseDao<T> {
    @Delete
    fun delete(obj: T)

    @Insert(onConflict = REPLACE)
    fun insert(obj: T): Long

    @Insert(onConflict = REPLACE)
    fun insertAll(vararg objects: T)

    @Insert(onConflict = REPLACE)
    fun insertAll(list: List<T>)

    @Update
    fun update(obj: T)
}