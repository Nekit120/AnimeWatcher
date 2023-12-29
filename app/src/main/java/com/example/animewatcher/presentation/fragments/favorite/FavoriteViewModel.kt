package com.example.animewatcher.presentation.fragments.favorite

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.usecase.FavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(val favoriteUseCase: FavoriteUseCase) : ViewModel() {
    private val resultListAnime = MutableLiveData<List<AnimeApiItemModel>>()
    val resultListAnimeLive: LiveData<List<AnimeApiItemModel>> = resultListAnime

    fun getAllListAnimeFromDB() {
        viewModelScope.launch(Dispatchers.IO) {
            resultListAnime.postValue(favoriteUseCase.getAllAnimeFromDb())
        }
    }
}