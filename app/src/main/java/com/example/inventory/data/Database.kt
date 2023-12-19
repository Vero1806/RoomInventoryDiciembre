package com.example.inventory.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
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
            fun getDatabase (context: Context): ItemRoomDatabase{
                return INTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ItemRoomDatabase::class.java,
                        "item_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INTANCE = instance
                    return instance
                }
            }
        }
}
