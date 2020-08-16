package com.example.music_room_database.room.singer

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface SingerDao{
    @Transaction
    @Insert
    fun createSinger(singer: Singer)

    @Query("SELECT * FROM Singer")
    fun getAllSinger(): LiveData<List<Singer>>

//    @Query("SELECT * FROM Singer WHERE singer_id= singer_id")
//    fun getSingerById(singer_id:Int): Singer
}