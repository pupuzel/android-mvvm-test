package com.example.testandroidx.testRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object{
        private val DB_NAME = "room-db"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context) :AppDatabase {
            return instance ?: synchronized(this){
                instance ?: Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
            }
        }
    }

}