package com.example.animewatcher.presentation.di

import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.AnimeInfoRepository
import com.example.animewatcher.domain.repository.FavoriteRepository
import com.example.animewatcher.domain.repository.SearchRepository
import com.example.animewatcher.domain.repository.WatchRepository
import com.example.animewatcher.domain.usecase.AnimeInfoUseCase
import com.example.animewatcher.domain.usecase.FavoriteUseCase
import com.example.animewatcher.domain.usecase.SearchUseCase
import com.example.animewatcher.domain.usecase.WatchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideWatchUseCase(watchRepository: WatchRepository): WatchUseCase {
        return WatchUseCase(watchRepository = watchRepository)
    }

    @Provides
    fun provideFavoriteUseCase(favoriteRepository: FavoriteRepository): com.example.animewatcher.domain.usecase.FavoriteUseCase {
        return com.example.animewatcher.domain.usecase.FavoriteUseCase(favoriteRepository)
    }

    @Provides
    fun provideSearchUseCase(searchRepository: SearchRepository): SearchUseCase {
        return SearchUseCase(searchRepository)
    }

    @Provides
    fun provideAnimeInfoUseCase(animeInfoRepository: AnimeInfoRepository): com.example.animewatcher.domain.usecase.AnimeInfoUseCase{
        return com.example.animewatcher.domain.usecase.AnimeInfoUseCase(animeInfoRepository)
    }

}