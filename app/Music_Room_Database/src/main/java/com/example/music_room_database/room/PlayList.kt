package com.example.music_room_database.room

import androidx.room.Embedded
import androidx.room.Relation
import com.example.music_room_database.room.music.Music
import com.example.music_room_database.room.singer.Singer

class PlayList (
    @Embedded val singer: Singer,
    @Relation(
        parentColumn = "singer_id",
        entityColumn = "id_singer"
    )
    val playList: List<Music>
)