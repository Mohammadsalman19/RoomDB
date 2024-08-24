package com.example.roomdb.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdb.daos.ContactDAO
import com.example.roomdb.entities.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactDB: RoomDatabase() {
    abstract fun getContactDAO () : ContactDAO
}
