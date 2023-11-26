package com.example.animewatcher.presentation

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.Nekit120.codeholder.presentation.di.AppModule
import com.Nekit120.codeholder.presentation.di.DataModule
import com.Nekit120.codeholder.presentation.di.DomainModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
@HiltAndroidApp
class App: Application() {
}