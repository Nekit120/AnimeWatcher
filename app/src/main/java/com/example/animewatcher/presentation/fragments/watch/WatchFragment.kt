package com.example.animewatcher.presentation.fragments.watch

import android.content.Context
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animewatcher.databinding.FragmentWatchBinding
import com.example.animewatcher.domain.model.AnimeItemModel
import com.example.animewatcher.presentation.adapters.AnimeItemWatchAdapter


class WatchFragment : Fragment() {

    lateinit var  animeWatchAdapter : AnimeItemWatchAdapter
    private val binding: FragmentWatchBinding by lazy {
        FragmentWatchBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val categotyList = listOf<AnimeItemModel>(
            AnimeItemModel("Всемогущая магия святой",242),
            AnimeItemModel("Всемогущая магия святой",242),
            AnimeItemModel("Всемогущая магия святой",242),
            AnimeItemModel("Всемогущая магия святой",242),
            AnimeItemModel("Всемогущая магия святой",242),
            AnimeItemModel("Всемогущая магия святой",242),
            AnimeItemModel("Всемогущая магия святой",242),
            AnimeItemModel("Всемогущая магия святой",242),
            AnimeItemModel("Всемогущая магия святой",242)
        )

        //RcViewAdapter
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.recyclerView.layoutManager = GridLayoutManager(activity as Context, 4)
        } else {
            binding.recyclerView.layoutManager = GridLayoutManager(activity as Context, 2)
        }
        animeWatchAdapter = AnimeItemWatchAdapter()
        binding.recyclerView.adapter = animeWatchAdapter

        //Проверка на подключение к интернету
        if (hasInternetConnection(requireActivity())){
            binding.progressBarInAnimeWatch.visibility = View.GONE
            animeWatchAdapter.setData(categotyList)
        } else {
            binding.errorCard.visibility = View.VISIBLE
        }

        //Пока что просто наброски
        fun loadData() {
            animeWatchAdapter.setData(categotyList)
            binding.swipeContainer.isRefreshing = false
            binding.errorCard.visibility = View.GONE
            binding.progressBarInAnimeWatch.visibility = View.GONE
        }

        binding.swipeContainer.setOnRefreshListener { loadData() }


        return binding.root
    }

    //Проверка на подключение к интернету
    fun hasInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return  capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }

}