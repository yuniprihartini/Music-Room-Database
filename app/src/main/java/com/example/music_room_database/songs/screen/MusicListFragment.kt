package com.example.music_room_database.songs.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music_room_database.R
import com.example.music_room_database.songs.recycleview.MusicRecycleAdapter
import com.example.music_room_database.songs.viewmodel.MusicViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_music_list.*


class MusicListFragment : Fragment(), View.OnClickListener {
val newMusicViewModel by activityViewModels<MusicViewModel>()
    lateinit var navController: NavController
    lateinit var adapter: MusicRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        album_name_in_music_list.text = arguments?.getString("title")
        Picasso.with(this.context).load(arguments?.getString("image")).into(image_singer_in_music_list)
        music_recycleView.layoutManager = LinearLayoutManager(activity)
        newMusicViewModel.getAllMusic(arguments?.getString("id")!!.toInt()).observe(viewLifecycleOwner, Observer {
            adapter = MusicRecycleAdapter(it)
            music_recycleView.adapter = adapter
        })
        navController = Navigation.findNavController(view)
        fabAddSong.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val bundle = bundleOf(Pair("music_id", arguments?.getString("id")))
        when (v){
            fabAddSong ->{
                navController.navigate(R.id.action_musicListFragment_to_addNewMusicFragment, bundle)
            }
        }
    }


}