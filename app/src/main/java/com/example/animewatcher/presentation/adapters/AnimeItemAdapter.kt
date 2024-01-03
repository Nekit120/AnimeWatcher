package com.example.animewatcher.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animewatcher.R
import com.example.animewatcher.databinding.AnimeWatchItemBinding
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.presentation.fragments.info.AnimeInfoFragment

class AnimeItemAdapter(private val context: Context, private val navController: NavController, private var animeItemList: List<AnimeApiItemModel> = emptyList()): RecyclerView.Adapter<AnimeItemAdapter.ItemHolder>() {

    class ItemHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = AnimeWatchItemBinding.bind(view)
        fun setData(animeItem: AnimeApiItemModel, context: Context,navController: NavController) = with(binding){
            itemView.setOnClickListener {
                when (navController.currentDestination?.id) {
                    R.id.navigation_watch -> {
                        navController.navigate(
                            R.id.action_navigation_watch_to_animeFragment,
                            bundleOf(AnimeInfoFragment.animeKey to animeItem)
                        )
                    }
                    R.id.navigation_search -> {
                        navController.navigate(
                            R.id.action_navigation_search_to_navigation_anime_info,
                            bundleOf(AnimeInfoFragment.animeKey to animeItem)
                        )
                    }
                    R.id.navigation_favorite -> {
                        navController.navigate(
                            R.id.action_navigation_favorite_to_animeFragment,
                            bundleOf(AnimeInfoFragment.animeKey to animeItem)
                        )
                    }
                }
             }
            if (animeItem.materialData!=null){
                Glide.with(context).load(animeItem.materialData!!.posterUrl).into(animePosterImageView)
                animeName.text = animeItem.materialData.title
            }



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
            holder.setData(animeItemList[position],context,navController)
    }

    fun setData(data: List<AnimeApiItemModel>) {
        animeItemList = data
        notifyDataSetChanged()
    }

}