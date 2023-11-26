package com.example.animewatcher.presentation.di

import com.example.animewatcher.data.repository.WatchRepositoryImpl
import com.example.animewatcher.domain.repository.WatchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideWatchRepository(): WatchRepository {
        return WatchRepositoryImpl()
    }

}