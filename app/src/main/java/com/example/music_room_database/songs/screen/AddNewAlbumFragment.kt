package com.example.music_room_database.songs.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.music_room_database.R
import com.example.music_room_database.room.singer.Singer
import com.example.music_room_database.songs.viewmodel.SingerViewModel
import kotlinx.android.synthetic.main.fragment_add_new_album.*

class AddNewAlbumFragment : Fragment(), View.OnClickListener {
    val newAlbumViewModel by activityViewModels<SingerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new_album, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_save_album.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            button_save_album -> {
                val name = input_singer_name.text.toString()
                val title = input_music_album.text.toString()
                val image = inputImageUrl.text.toString()
                if (name == "" || title == "" || image == "") {
                    Toast.makeText(this.context, "Must be Filled", Toast.LENGTH_LONG).show()
                } else {
                    newAlbumViewModel.createNewSinger(Singer(name=name,title=title,image=image))
                    Toast.makeText(this.context, "Data Successfull Added", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }


}