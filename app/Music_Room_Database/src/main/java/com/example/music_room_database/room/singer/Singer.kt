package com.example.music_room_database.room.singer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Singer(
    @PrimaryKey(autoGenerate = true) @ColumnInfo var singer_id: Int = 0,
    @ColumnInfo(name="name") var name:String,
    @ColumnInfo(name="title") var title:String,
    @ColumnInfo(name="image") var image:String
){

}