package com.example.animewatcher.presentation.di

import com.example.animewatcher.data.database.MainDatabase
import com.example.animewatcher.data.repository.AnimeInfoRepositoryImpl
import com.example.animewatcher.data.repository.FavoriteRepositoryImpl
import com.example.animewatcher.data.repository.WatchRepositoryImpl
import com.example.animewatcher.domain.repository.AnimeInfoRepository
import com.example.animewatcher.domain.repository.FavoriteRepository
import com.example.animewatcher.domain.repository.WatchRepository
import com.example.animewatcher.presentation.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


val okHttpClient = OkHttpClient.Builder()
    .connectTimeout(30, TimeUnit.SECONDS) // Увеличиваем таймаут на установление соединения до 30 секунд
    .readTimeout(30, TimeUnit.SECONDS)    // Увеличиваем таймаут на чтение данных до 30 секунд
    .writeTimeout(30, TimeUnit.SECONDS)   // Увеличиваем таймаут на запись данных до 30 секунд
    .build()

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideWatchRepository(retrofit: Retrofit): WatchRepository {
        return WatchRepositoryImpl(retrofit)
    }
    @Provides
    @Singleton
    fun provideAnimeInfoRepository (database: MainDatabase) : AnimeInfoRepository {
        return AnimeInfoRepositoryImpl(database)
    }

    @Provides
    @Singleton
    fun provideFavoriteRepository(database: MainDatabase): FavoriteRepository {
        return FavoriteRepositoryImpl(database)
    }

    @Provides
    @Singleton
    fun provideDatabase(): MainDatabase {
        return App.database
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://kodikapi.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit
    }

}