package com.example.remote

import com.example.`object`.Constant
import com.example.core.network.BaseDataSource
import com.example.network.RetrofitClient

class RemoteDataSource: BaseDataSource() {

    private var apiService: YoutubeApi = RetrofitClient.create()

    suspend fun fetchAllPlaylist() = getResult {
        apiService.fetchAllPlayList(Constant.PART,Constant.CHANNEL_ID,Constant.API_KEY,20)
    }

    suspend fun fetchVideoPlaylist() = getResult {
        apiService.fetchPlayListVideo(Constant.PART, Constant.API_KEY,Constant.CHANNEL_ID, 50)
    }
}