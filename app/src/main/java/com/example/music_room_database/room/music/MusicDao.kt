package com.example.music_room_database.room.music

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.music_room_database.room.PlayList

@Dao
interface MusicDao {
    @Insert
    fun createMusic(music: Music)

    @Transaction
    @Query("SELECT * FROM Singer WHERE singer_id = :id_singer")
    fun getAllMusic(id_singer: Int): LiveData<PlayList>

    @Query("SELECT * FROM Music WHERE id= :id")
    fun getMusicById(id: Int): Music
}