package com.example.animewatcher.presentation.fragments.watch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animewatcher.domain.model.AnimeItemApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.usecase.WatchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchViewModel @Inject constructor(val watchUseCase: WatchUseCase) :ViewModel() {

    private val resultListAnime = MutableLiveData<List<AnimeApiItemModel>>()
    val resultListMenuLive: LiveData<List<AnimeApiItemModel>> = resultListAnime

    fun getLastUpdatesAnimeList() {
        viewModelScope.launch(Dispatchers.IO) {
            resultListAnime.postValue(watchUseCase.getLastUpdatesAnimeList())

        }
    }
    fun resetToZeroAnimeList() {
        viewModelScope.launch(Dispatchers.IO) {
            resultListAnime.postValue(emptyList())
        }
    }

}