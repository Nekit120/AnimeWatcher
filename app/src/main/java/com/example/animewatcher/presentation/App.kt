package com.example.animewatcher.presentation

import android.app.Application
import com.example.animewatcher.data.database.MainDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    companion object {
        lateinit var instance: App
        val database by lazy { MainDatabase.getDatabase(context = instance) }
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}