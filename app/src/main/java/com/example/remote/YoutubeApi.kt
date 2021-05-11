package com.example.remote

import com.example.model.PlayList
import com.example.model.PlayListDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("playlists")
    suspend fun fetchAllPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
        @Query("maxResults") maxResult: Int
    ): Response<PlayList>

    @GET("playlistsItems")
    suspend fun fetchPlayListVideo(
        @Query("part") part: String,
        @Query("playlistId") id: String,
        @Query("key") apiKey: String,
        @Query("maxResults") maxResult: Int
    ): Response<PlayList>



}