package com.example.myapplication.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.bd.model.Event
import com.example.myapplication.bd.dao.EventDao


@Database(entities = arrayOf(Event::class), version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun eventDao(): EventDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "roomdb")
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }
}