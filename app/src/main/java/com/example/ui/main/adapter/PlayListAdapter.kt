package com.example.ui.main

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.extensions.inflate
import com.example.extensions.loadImage
import com.example.model.Items
import com.example.youtubeapi.R
import kotlinx.android.synthetic.main.item_playlist.view.*

class PlayListAdapter(
    private val listener: OnItem,
): RecyclerView.Adapter<ViewHolder>() {

    private var playList = ArrayList<Items>()

    fun addItems(list: MutableList<Items>) {
        playList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(parent.inflate(R.layout.item_playlist
           ,false),listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playList[position])
    }

    override fun getItemCount() = playList.size
}

class ViewHolder(itemView: View, var listener: OnItem)
    : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("SetTextI18n")
    fun onBind(playList: Items) {

        itemView.textTitle.text = playList.snippet.title
        itemView.subTitle.text = playList.contentDetails.itemCount.toString() + " Videos"

        itemView.imageView.loadImage(itemView.context,
            playList.snippet.thumbnails.default.url)

        itemView.setOnClickListener {
            listener.onPlayListItemClick(playList)
        }

    }
}

interface OnItem {
    fun onPlayListItemClick(playList: Items)
}
