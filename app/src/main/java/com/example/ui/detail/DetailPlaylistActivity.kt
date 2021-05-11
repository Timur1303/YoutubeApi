package com.example.ui.detail

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.network.result.Status
import com.example.core.ui.BaseActivity
import com.example.extensions.showMessage
import com.example.model.DetailVideo
import com.example.model.Items
import com.example.model.PlayList
import com.example.ui.detail.adapter.DetailAdapter
import com.example.ui.detail.adapter.OnClick
import com.example.youtubeapi.R
import kotlinx.android.synthetic.main.activity_detail_playlist.*

@Suppress("UNCHECKED_CAST")
class DetailPlaylistActivity: BaseActivity(R.layout.activity_detail_playlist), OnClick {

    private var viewModel: DetailPlaylistViewModel? = null
    private lateinit var adapter: DetailAdapter
    private lateinit var id: String

    override fun setupUI() {
        viewModel = ViewModelProvider(this).get(DetailPlaylistViewModel::class.java)
    }

    override fun setupLiveData() {
        id = intent.getStringExtra("playlistId").toString()
        initRecyclerView()
        initAdapter()
        initAppbar()
    }

    private fun initRecyclerView() {
        viewModel?.loading?.observe(this,{
        })

        viewModel?.fetchPlayListItem()?.observe(this,{ resource ->

            when(resource.status) {

                Status.LOADING -> {
                    viewModel?.loading?.postValue(true)
                }
                Status.SUCCESS -> {
                    adapter.add(resource.data?.items as MutableList<Items>)
                    viewModel?.loading?.postValue(false)
                }
                Status.ERROR -> {
                    viewModel?.loading?.postValue(false)
                }
            }
        })
    }

    private fun initAdapter(){
        adapter = DetailAdapter(this)
        video_list_recycler.layoutManager = LinearLayoutManager(baseContext)
        video_list_recycler.adapter = adapter
    }

    private fun initAppbar(){
        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        tv_name.text = title
        tv_description.text = desc
    }

    override fun showDisconnectState() {
    }

    override fun onPlayListItemClick(items: Items) {
    }


}