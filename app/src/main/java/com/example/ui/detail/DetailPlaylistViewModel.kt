package com.example.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.YouTubeApp
import com.example.core.network.result.Resource
import com.example.core.ui.BaseViewModel
import com.example.model.PlayList
import com.example.model.PlayListDetail

class DetailPlaylistViewModel: BaseViewModel() {

    var loading = MutableLiveData<Boolean>()

    fun fetchPlayListItem(id: String): LiveData<Resource<PlayListDetail>> {
        return YouTubeApp.repository.fetchPlaylistVideo(id)
    }
}