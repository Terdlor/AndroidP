package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.example.myapplication.bd.AppDatabase
import com.example.myapplication.bd.model.Event
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.lang.Exception
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var mDb: AppDatabase

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            // Initialize the room database
            mDb = AppDatabase.getInstance(this)

            // Make the text view scrollable
            textView.movementMethod = ScrollingMovementMethod()
        } catch (e: Exception) {
            tvInfo.text = e.toString()
        }

        // Insert button click listener
        btnInsert.setOnClickListener {
            // Initialize a new student
            val student = Event(null, UUID.randomUUID().toString(), Calendar.getInstance())

            doAsync {
                // Put the student in database
                try {
                    mDb.eventDao().insert(student)

                    uiThread {
                        toast("One record inserted.")
                    }
                } catch (e: Exception) {
                    tvInfo.text = e.toString()
                }
            }
        }

        // Select button click listener
        btnSelect.setOnClickListener {
            doAsync {
                // Get the student list from database
                try {
                    val list = mDb.eventDao().getAll()

                    uiThread {
                        toast("${list.size} records found.")
                        // Display the students in text view
                        textView.text = ""
                        for (student in list) {
                            textView.append("${student.id} : ${student.description} : ${student.getCalendar().time}\n")
                        }
                    }
                } catch (e: Exception) {
                    tvInfo.text = e.toString()
                }
            }
        }
    }
}
