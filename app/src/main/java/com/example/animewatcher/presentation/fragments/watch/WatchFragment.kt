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
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animewatcher.databinding.FragmentWatchBinding
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.presentation.adapters.AnimeItemAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WatchFragment : Fragment() {
    lateinit var  animeWatchAdapter : AnimeItemAdapter
    private val binding: FragmentWatchBinding by lazy {
        FragmentWatchBinding.inflate(layoutInflater)
    }
    private val viewModel: WatchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        //RcViewAdapter
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.recyclerView.layoutManager = GridLayoutManager(activity as Context, 4)
        } else {
            binding.recyclerView.layoutManager = GridLayoutManager(activity as Context, 2)
        }

        val navController = findNavController()
        animeWatchAdapter = AnimeItemAdapter(requireActivity(),navController)
        binding.recyclerView.adapter = animeWatchAdapter


        loadData()


        viewModel.resultListAnimeLive.observe(requireActivity(),{
            animeWatchAdapter.setData(it)
            binding.swipeContainer.isRefreshing = false
            if(hasInternetConnection(requireActivity())){
                binding.progressBarInAnimeWatch.visibility = View.GONE }
            else { binding.progressBarInAnimeWatch.visibility = View.VISIBLE}
        })

        binding.swipeContainer.setOnRefreshListener { loadData() }
        return binding.root
    }

    //Работа с обновлением при свайпе сверху вних
    fun loadData() {
        //Проверка на подключение к интернету
        if (hasInternetConnection(requireActivity())){
            viewModel.getLastUpdatesAnimeList()
            binding.errorCard.visibility = View.GONE
        } else {
            viewModel.resetToZeroAnimeList()
            binding.errorCard.visibility = View.VISIBLE
            binding.progressBarInAnimeWatch.visibility = View.VISIBLE
        }
    }

    //Проверка на подключение к интернету
    fun hasInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return  capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }

}