package com.example.inventory.data
import androidx.room.Database
import androidx.room.RoomDatabase
import kotlin.jvm.Volatile

@Database(entities = [Item::class],
    version = 1,
    exportSchema = false)
abstract class ItemRoomDatabase : RoomDatabase() {
    abstract fun ItemDao(): ItemDao
        companion object {
            @Volatile
            private var INTANCE: ItemRoomDatabase? = null
        }

}
