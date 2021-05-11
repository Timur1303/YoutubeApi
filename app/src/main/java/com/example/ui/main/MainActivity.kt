package com.example.ui.main

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.network.result.Status
import com.example.core.ui.BaseActivity
import com.example.extensions.showMessage
import com.example.model.Items
import com.example.model.PlayList
import com.example.ui.detail.DetailPlaylistActivity
import com.example.ui.nointernet.NoInternetActivity
import com.example.youtubeapi.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main), OnItem {

    private var viewModel: MainViewModel? = null
    private lateinit var adapter: PlayListAdapter

    override fun setupUI() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun setupLiveData() {

        initAdapter()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        viewModel?.loading?.observe(this,{
        })

        viewModel?.fetchPlayList()?.observe(this,{ resource ->

            when(resource.status) {

                Status.LOADING -> {
                    viewModel?.loading?.postValue(true)
                }
                Status.SUCCESS -> {
                    adapter.addItems(resource.data?.items as MutableList<Items>)
                    viewModel?.loading?.postValue(false)
                }
                Status.ERROR -> {
                    viewModel?.loading?.postValue(false)
                }
            }
        })
    }

    private fun initAdapter(){
        adapter = PlayListAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(baseContext)
        recycler_view.adapter = adapter
    }



    override fun showDisconnectState() {

    }

    override fun onPlayListItemClick(playList: Items) {
        val intent  = Intent(this, DetailPlaylistActivity::class.java)
        intent.putExtra("playlistId", playList.id)
        intent.putExtra("title", playList.snippet.title)
        intent.putExtra("desc", playList.snippet.description)
        startActivity(intent)
    }
}