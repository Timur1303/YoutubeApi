package com.example.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.YouTubeApp
import com.example.core.network.result.Resource
import com.example.core.ui.BaseViewModel
import com.example.model.PlayList
import retrofit2.Response

class MainViewModel : BaseViewModel() {

    var loading = MutableLiveData<Boolean>()

    fun fetchPlayList(): LiveData<Resource<PlayList>> {
        return YouTubeApp.repository.fetchYoutubeApiPlayList()
    }
}