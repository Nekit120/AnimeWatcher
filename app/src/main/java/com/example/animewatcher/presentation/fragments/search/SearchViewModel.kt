package com.example.animewatcher.presentation.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(val searchUseCase: SearchUseCase): ViewModel() {

    private val resultSearchAnimeItem = MutableLiveData<List<AnimeApiItemModel>>()
    val resultSearchAnimeItemLive: LiveData<List<AnimeApiItemModel>> = resultSearchAnimeItem

    fun getSearchAnimeList(animeTitleName:String) {
        viewModelScope.launch(Dispatchers.IO){
            val animeList = mutableListOf<AnimeApiItemModel>()
            for (animeItem in searchUseCase.getSearchAnime(animeTitleName)){
                if (animeItem.materialData!=null){
                    animeList.add(animeItem)
                }
            }
            resultSearchAnimeItem.postValue(animeList)
        }
    }

}