package com.example.music_room_database.songs.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.music_room_database.room.AppRoomDatabase
import com.example.music_room_database.room.music.Music
import com.example.music_room_database.room.music.MusicRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MusicViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MusicRepository

    init{
        val musicDao = AppRoomDatabase.getDatabaseInstance(application).musicDao()
        repository = MusicRepository(musicDao)
    }

    fun getAllMusic(id: Int) = repository.getAllMusic(id)
    fun createNewMusic(music: Music){
        viewModelScope.launch(Dispatchers.IO){
            repository.createMusic(music)
        }
    }
}