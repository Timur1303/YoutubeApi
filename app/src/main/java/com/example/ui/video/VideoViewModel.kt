package com.example.ui.video

import androidx.lifecycle.LiveData
import com.example.YouTubeApp
import com.example.core.network.result.Resource
import com.example.core.ui.BaseViewModel
import com.example.model.PlayList

class VideoViewModel : BaseViewModel() {

    fun fetchVideo(): LiveData<Resource<PlayList>>{
        return YouTubeApp.repository.fetchVideoFromList()
    }
}