package com.example.roomdb

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdb.database.ContactDB
import com.example.roomdb.entities.Contact
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var textId: EditText
    private lateinit var textName: EditText
    private lateinit var textPhone: EditText

    private lateinit var insert: Button
    private lateinit var update: Button
    private lateinit var delete: Button
    private lateinit var read: Button

    private lateinit var database: ContactDB

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        database = ContactDB.getInstance(this)

        textId = findViewById(R.id.editTextId)
        textName = findViewById(R.id.editTextName)
        textPhone = findViewById(R.id.editTextPhone)

        insert = findViewById(R.id.buttonInsert)
        update = findViewById(R.id.buttonUpdate)
        delete = findViewById(R.id.buttonDelete)
        read = findViewById(R.id.buttonRead)



        insert.setOnClickListener {
            GlobalScope.launch {
                val contact = Contact(0, textName.text.toString(), textPhone.text.toString())
                database.getContactDAO().insert(contact)
            }

        }

        update.setOnClickListener {
            GlobalScope.launch {
                val contact = Contact(textId.text.toString().toInt(), textName.text.toString(), textPhone.text.toString())
                database.getContactDAO().update(contact)
            }

        }

        delete.setOnClickListener {
            GlobalScope.launch {
                val contact = Contact(textId.text.toString().toInt(), textName.text.toString(), textPhone.text.toString())
                database.getContactDAO().delete(contact)
            }
        }

    }
}