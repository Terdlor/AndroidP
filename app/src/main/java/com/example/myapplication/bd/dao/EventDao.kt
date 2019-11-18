package com.example.myapplication.bd.dao

import androidx.room.*
import com.example.myapplication.bd.model.Event


@Dao
interface EventDao{

    @Query("SELECT * FROM EVENT")
    fun getAll() : List<Event>

    @Query("SELECT * FROM EVENT WHERE ID = :id")
    fun getById(id : Long) : Event

    @Insert
    fun insert(event: Event)

    @Update
    fun update(event: Event)

    @Delete
    fun delete(event: Event)
}