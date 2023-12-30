package com.example.animewatcher.presentation.fragments.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.usecase.AnimeInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeInfoViewModel @Inject constructor(val animeInfoUseCase: AnimeInfoUseCase):ViewModel() {
    fun addAnimeItemInDb(animeItem:AnimeApiItemModel){
        viewModelScope.launch(Dispatchers.IO) {
            animeInfoUseCase.addAnimeItemInDb(animeItem)
        }
    }
}