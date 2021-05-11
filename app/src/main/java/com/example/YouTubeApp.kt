package com.example

import android.app.Application
import com.example.remote.RemoteDataSource
import com.example.repository.Repository

class YouTubeApp: Application() {

    companion object {

        val repository = Repository(RemoteDataSource())
    }

}