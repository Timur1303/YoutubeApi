package com.example.core.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(private val layout: Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        showDisconnectState()
        setupUI()
        setupLiveData()
    }

    abstract fun setupUI() // внутри этого метода мы инициализирем все view

    abstract fun setupLiveData() // внутри этого метода мы инициализируем все liveData

    abstract fun showDisconnectState()

}