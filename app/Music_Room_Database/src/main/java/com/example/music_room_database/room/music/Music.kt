package com.example.music_room_database.room.music

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
class Music (
    @PrimaryKey(autoGenerate = true) @ColumnInfo var id:Int=0,
    @ColumnInfo(name="id_singer") @NotNull var id_singer:Int,
    @ColumnInfo(name="title") var title: String,
    @ColumnInfo(name="duration") var duration: String
){

}