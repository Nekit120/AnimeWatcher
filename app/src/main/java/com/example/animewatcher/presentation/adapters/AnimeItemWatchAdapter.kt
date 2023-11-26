package com.example.animewatcher.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animewatcher.R
import com.example.animewatcher.databinding.AnimeWatchItemBinding
import com.example.animewatcher.domain.model.AnimeItemApiModel.AnimeApiItemModel

class AnimeItemWatchAdapter(private val context: Context,private var animeItemList: List<AnimeApiItemModel> = emptyList()): RecyclerView.Adapter<AnimeItemWatchAdapter.ItemHolder>() {



    class ItemHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = AnimeWatchItemBinding.bind(view)
        val baseUrlImg = "https://anilibria.tv"
        fun setData(animeItem: AnimeApiItemModel,context: Context) = with(binding){
            val fullUrlImg = baseUrlImg + animeItem.posters.original.url
            animeName.text = animeItem.names.ru
            itemView.setOnClickListener{

            }
            Glide.with(context).load(fullUrlImg).into(animePosterImageView)
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
      holder.setData(animeItemList[position],context)
    }

    fun setData(data: List<AnimeApiItemModel>) {
        animeItemList = data
        notifyDataSetChanged()
    }


}