package com.example.roomdb.database

import androidx.room.Database
import com.example.roomdb.daos.ContactDAO
import com.example.roomdb.entities.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactDB {

    abstract fun getContactDAO () : ContactDAO
}
