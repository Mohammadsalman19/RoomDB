package com.example.roomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdb.daos.ContactDAO
import com.example.roomdb.entities.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactDB : RoomDatabase() {
    abstract fun getContactDAO(): ContactDAO

    companion object {

        @Volatile
        private var instance: ContactDB? = null

        @Synchronized
        fun getInstance(context: Context): ContactDB {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDB::class.java,
                    "Contact_database"
                ).build()
            }

            return instance!!
        }
    }
}
