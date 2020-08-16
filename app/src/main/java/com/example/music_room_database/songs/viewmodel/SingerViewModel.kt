package com.example.music_room_database.songs.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.music_room_database.room.AppRoomDatabase
import com.example.music_room_database.room.singer.Singer
import com.example.music_room_database.room.singer.SingerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//untuk membaca db

class SingerViewModel (application: Application):AndroidViewModel(application){
    private val repository : SingerRepository
    val allSinger : LiveData<List<Singer>>
    init {
        val singerDao = AppRoomDatabase.getDatabaseInstance(application).singerDao()
        repository = SingerRepository(singerDao)
        allSinger = repository.allSinger
    }
    fun createNewSinger(singer: Singer){
        viewModelScope.launch(Dispatchers.IO){
            repository.createSinger(singer)
        }
    }
}