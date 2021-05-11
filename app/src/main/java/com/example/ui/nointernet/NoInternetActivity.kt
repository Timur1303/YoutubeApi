package com.example.ui.nointernet

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.getSystemService
import com.example.core.ui.BaseActivity
import com.example.ui.detail.DetailPlaylistActivity
import com.example.ui.main.MainActivity
import com.example.youtubeapi.R
import kotlinx.android.synthetic.main.activity_no_internet.*

class NoInternetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_internet)

    val connectionManager: ConnectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        btn_try_again.setOnClickListener {
            val activeNetwork: NetworkInfo? = connectionManager.activeNetworkInfo
            val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
            if (isConnected){
                val intent  = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                tv_connection.text = "No Internet Connection"
            }
        }
    }
}