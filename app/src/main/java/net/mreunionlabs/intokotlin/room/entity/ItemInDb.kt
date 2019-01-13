package net.mreunionlabs.intokotlin.room.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "item_in_db")
data class ItemInDb(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val content: String
)