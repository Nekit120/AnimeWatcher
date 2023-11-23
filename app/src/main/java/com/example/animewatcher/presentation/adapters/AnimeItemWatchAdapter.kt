package com.example.animewatcher.presentation.adapters

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animewatcher.R
import com.example.animewatcher.databinding.AnimeWatchItemBinding
import com.example.animewatcher.domain.model.AnimeItemModel

class AnimeItemWatchAdapter(private var animeItemList: List<AnimeItemModel> = emptyList()): RecyclerView.Adapter<AnimeItemWatchAdapter.ItemHolder>() {



    class ItemHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = AnimeWatchItemBinding.bind(view)

        fun setData(animeItem: AnimeItemModel) = with(binding){
            animeName.text = animeItem.name
            animePosterImageView.setImageResource(R.drawable.anime_poster)
        }
        companion object{
                fun createItemHolder(parent: ViewGroup): ItemHolder {
                    return ItemHolder(LayoutInflater.from(parent.context).
                    inflate(R.layout.anime_watch_item,parent,false))
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.createItemHolder(parent)
    }

    override fun getItemCount() = animeItemList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
      holder.setData(animeItemList[position])
    }

    fun setData(data: List<AnimeItemModel>) {
        animeItemList = data
        notifyDataSetChanged()
    }


}