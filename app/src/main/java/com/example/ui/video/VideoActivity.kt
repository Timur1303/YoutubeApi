package com.example.ui.video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.core.ui.BaseActivity
import com.example.youtubeapi.R

class VideoActivity : BaseActivity(R.layout.activity_video) {

    private var viewModel: VideoViewModel? = null

    override fun setupUI() {
        viewModel = ViewModelProvider(this).get(VideoViewModel::class.java)

    }

    override fun setupLiveData() {
        TODO("Not yet implemented")
    }

    override fun showDisconnectState() {
        TODO("Not yet implemented")
    }

}