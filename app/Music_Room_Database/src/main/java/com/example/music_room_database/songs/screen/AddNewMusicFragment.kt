package com.example.music_room_database.songs.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.music_room_database.R
import com.example.music_room_database.room.music.Music
import com.example.music_room_database.songs.viewmodel.MusicViewModel
import kotlinx.android.synthetic.main.fragment_add_new_music.*


class AddNewMusicFragment : Fragment(), View.OnClickListener {
    val newMusicViewModel by activityViewModels<MusicViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_save_music.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            button_save_music -> {
                val title = input_title_music.text.toString()
                val duration = input_duration.text.toString()
                val id = arguments?.getString("music_id")!!.toInt()
                if (title == "" || duration == "") {
                    Toast.makeText(this.context, "Must be Filled", Toast.LENGTH_LONG).show()
                } else {
                    newMusicViewModel.createNewMusic(
                        Music(
                            title = title,
                            duration = duration,
                            id_singer = id
                        )
                    )
                    Toast.makeText(this.context, "Data Added Successfully", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}