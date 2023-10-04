package com.github.mutoxu_n.mysqlsync

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface WordDAO {
    @Insert
    fun insert(word: Word): Long

    @Update
    fun update(word: Word)

    @Delete
    fun delete(word: Word)

    @Query("SELECT * FROM entities")
    fun getAll(): List<Word>

    @Query("SELECT * FROM entities WHERE id=:id")
    fun get(id: Long): Word?



}