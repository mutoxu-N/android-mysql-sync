package com.github.mutoxu_n.mysqlsync

import androidx.room.Room
import androidx.room.RoomDatabase

@androidx.room.Database(entities = [
    Word::class
], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun wordDAO(): WordDAO

    companion object {
        @Volatile
        private var INSTANCE: Database? = null

        fun getDatabase(): Database {
            return INSTANCE ?: synchronized(this) {
                // インスタンスが無かったら生成して返す
                val instance = Room.databaseBuilder(
                    App.applicationContext!!,
                    Database::class.java,
                    "secretaryDB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}