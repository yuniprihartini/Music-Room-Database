package com.example.music_room_database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.music_room_database.room.music.Music
import com.example.music_room_database.room.music.MusicDao
import com.example.music_room_database.room.singer.Singer
import com.example.music_room_database.room.singer.SingerDao

@Database(entities = arrayOf(Singer::class, Music::class), version = 3, exportSchema = false )
public abstract class AppRoomDatabase : RoomDatabase(){
    abstract fun singerDao(): SingerDao
    abstract fun musicDao(): MusicDao


    companion object{
        private var DATABASE_INSTANCE:AppRoomDatabase?=null

        fun getDatabaseInstance(context: Context): AppRoomDatabase{
            if(DATABASE_INSTANCE!=null){
                return DATABASE_INSTANCE as AppRoomDatabase
            }
            DATABASE_INSTANCE = Room
                .databaseBuilder(context.applicationContext
                    , AppRoomDatabase::class.java
                    , "music_database").fallbackToDestructiveMigration().build()
            return DATABASE_INSTANCE as AppRoomDatabase
        }
    }
}