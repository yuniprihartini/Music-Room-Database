package com.example.music_room_database.songs.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.music_room_database.R
import com.example.music_room_database.room.PlayList

class MusicRecycleAdapter (private val musicList: PlayList):

        RecyclerView.Adapter<MusicViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_recycle_view, parent, false)
        return MusicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return musicList.playList.size
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.titleView.text = musicList.playList[position].title
        holder.durationView.text =  musicList.playList[position].duration
        var isPlay: Boolean = true
        holder.playButton.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)
        holder.playButton.setOnClickListener {
            if (isPlay) {
                holder.playButton.setBackgroundResource(R.drawable.ic_baseline_pause_24)
                isPlay = false
            } else {
                holder.playButton.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)
                isPlay = true
            }
        }
    }
}

class MusicViewHolder(v: View) : RecyclerView.ViewHolder(v){
    val titleView = v.findViewById<TextView>(R.id.music_title_in_recycle_view)
    val durationView = v.findViewById<TextView>(R.id.music_duration_in_music_recycle_view)
    val playButton = v.findViewById<Button>(R.id.playButton)

}