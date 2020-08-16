package com.example.music_room_database.room.singer

import androidx.lifecycle.LiveData

class SingerRepository (private val singerDao: SingerDao){
    val allSinger:LiveData<List<Singer>> = singerDao.getAllSinger()
    fun createSinger(singer: Singer){
        singerDao.createSinger(singer)
    }
}