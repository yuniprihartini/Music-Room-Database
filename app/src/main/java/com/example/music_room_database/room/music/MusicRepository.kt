package com.example.music_room_database.room.music

class MusicRepository (private val musicDao: MusicDao){

    fun getAllMusic(id:Int) = musicDao.getAllMusic(id)
    fun createMusic(music: Music){
        musicDao.createMusic(music)
    }
}