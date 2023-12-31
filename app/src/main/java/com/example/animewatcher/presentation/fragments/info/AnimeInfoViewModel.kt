package com.example.animewatcher.presentation.fragments.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val resultCheckingAnimeItemInFavorite = MutableLiveData<Boolean>()
    val resultCheckingAnimeItemInFavoriteLive: LiveData<Boolean> = resultCheckingAnimeItemInFavorite


    fun getFirstResultAnimeItemChecking(animeId:String) {
        viewModelScope.launch(Dispatchers.IO) {
            resultCheckingAnimeItemInFavorite.postValue(!animeInfoUseCase.matchСheckingAnimeItem(animeId))
        }
    }
    fun addOrDeleteAnimeItemInDb(animeItem:AnimeApiItemModel){
        viewModelScope.launch(Dispatchers.IO) {
            val resultChecking = animeInfoUseCase.matchСheckingAnimeItem(animeItem.id)
            if (resultChecking){
                animeInfoUseCase.deleteAnimeItemFromDb(animeItem)
                resultCheckingAnimeItemInFavorite.postValue(true)
            }
            else {
                animeInfoUseCase.addAnimeItemInDb(animeItem)
                resultCheckingAnimeItemInFavorite.postValue(false)
            }
        }
    }
}