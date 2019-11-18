package com.example.myapplication.bd.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "EVENT")
class Event {

    constructor(id : Long?, description: String, date : String){
        this.id = id
        this.description = description
        this.date = date
    }

    @PrimaryKey
    @ColumnInfo(name = "ID")
    var id: Long? = null

    @ColumnInfo(name = "DESCRIPTION")
    var description: String? = null

    @ColumnInfo(name = "DATE")
    var date: String? = null
}