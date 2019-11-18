package com.example.myapplication.bd.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * EVENT
 */
@Entity(tableName = "EVENT")
class Event {

    constructor(id : Long?, description: String, date : Long?){
        this.id = id
        this.description = description
        this.date = date
    }

    constructor(id : Long?, description: String, date : Calendar?){
        this.id = id
        this.description = description
        this.date = dateToTimestamp(date)
    }

    @PrimaryKey
    @ColumnInfo(name = "ID")
    var id: Long? = null

    @ColumnInfo(name = "DESCRIPTION")
    var description: String? = null

    @ColumnInfo(name = "DATE")
    var date: Long? = null

    fun getCalendar() : Calendar{
        val c = Calendar.getInstance()
        c.time =  toDate(date)
        return c
    }


    private fun dateToTimestamp(time: Calendar ?): Long? {
        return if (time == null) null else time.getTime().getTime()
    }

    private fun toDate(dateLong: Long?): Date? {
        return if (dateLong == null) null else Date(dateLong)
    }
}