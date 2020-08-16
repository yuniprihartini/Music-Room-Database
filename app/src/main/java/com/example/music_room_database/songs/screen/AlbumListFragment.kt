package com.example.music_room_database.songs.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music_room_database.R
import com.example.music_room_database.songs.recycleview.SingerRecycleAdapter
import com.example.music_room_database.songs.viewmodel.SingerViewModel
import kotlinx.android.synthetic.main.fragment_album_list.*



class AlbumListFragment : Fragment(),View.OnClickListener {
    val newAlbumViewModel by activityViewModels<SingerViewModel>()
    lateinit var navController: NavController
    lateinit var adapter : SingerRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        album_list_recycler_view.layoutManager = LinearLayoutManager(activity)
        newAlbumViewModel.allSinger.observe(viewLifecycleOwner, Observer {
            adapter = SingerRecycleAdapter(it,activity)
            album_list_recycler_view.adapter = adapter
        })
        navController = Navigation.findNavController(view)
        fabAddAlbum.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            fabAddAlbum -> {
                navController.navigate(R.id.action_albumListFragment_to_addNewAlbumFragment)
            }
        }
    }
}