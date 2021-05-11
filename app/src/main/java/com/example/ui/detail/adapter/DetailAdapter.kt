package com.example.ui.detail.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.extensions.inflate
import com.example.extensions.loadImage
import com.example.model.DetailVideo
import com.example.model.Items
import com.example.youtubeapi.R
import kotlinx.android.synthetic.main.item_playlist.view.*
import java.util.ArrayList

class DetailAdapter(
    private val listener: OnClick
): RecyclerView.Adapter<ViewHolder>() {

    private var itemList = ArrayList<Items>()

    fun add(list: MutableList<Items>) {
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(
            R.layout.item_playlist
            ,false),listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(itemList[position])

    }

    override fun getItemCount() = itemList.size

}

class ViewHolder(itemView: View, var listener: OnClick)
    : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("SetTextI18n")
    fun onBind(items: Items) {

        itemView.textTitle.text = items.snippet?.title

        itemView.imageView.loadImage(detailVideo.snippet?.thumbnails?.medium?.toString())

        itemView.setOnClickListener {
            listener.onPlayListItemClick(items)
        }

    }
}

interface OnClick{
    fun onPlayListItemClick(items: Items)
}