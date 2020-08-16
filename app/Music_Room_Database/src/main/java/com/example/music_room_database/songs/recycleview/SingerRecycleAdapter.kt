package com.example.music_room_database.songs.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.music_room_database.R
import com.example.music_room_database.room.singer.Singer
import com.squareup.picasso.Picasso

class SingerRecycleAdapter (
    private val singerList: List<Singer>,
    private val getActivity: FragmentActivity?
):
    RecyclerView.Adapter<SingerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_recycle_view, parent, false)
        return SingerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return singerList.size
    }

    override fun onBindViewHolder(holder: SingerViewHolder, position: Int) {
        holder.nameView.text = singerList[position].name
        holder.titleView.text = singerList[position].title
        Picasso.with(getActivity).load(singerList[position].image).into(holder.imageViewURL)
        val bundle = bundleOf(
            Pair("title", singerList[position].title), Pair("image", singerList[position].image),
            Pair("id", singerList[position].singer_id.toString())
        )
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_albumListFragment_to_musicListFragment, bundle)
        }
    }
}
class SingerViewHolder(v: View) : RecyclerView.ViewHolder(v){
    val nameView = v.findViewById<TextView>(R.id.singer_name_text_view)
    val titleView = v.findViewById<TextView>(R.id.album_title_text_view)
    val imageViewURL: ImageView = v.findViewById(R.id.image_view_album_url)
}