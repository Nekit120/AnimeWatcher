package com.example.animewatcher.presentation.fragments.search

import android.content.Context
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animewatcher.databinding.FragmentSearchBinding
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.presentation.adapters.AnimeItemAdapter
import com.example.animewatcher.presentation.fragments.info.AnimeInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    //Проверка на подключение к интернету
    fun hasInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return  capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }

    lateinit var  animeSearchAdapter : AnimeItemAdapter
    private val binding : FragmentSearchBinding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
    }

    private val viewModel: SearchViewModel by viewModels ()
    // Создаем Handler, связанный с основным потоком (UI thread)
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding.searchAnimeItem.addTextChangedListener{
            binding.emptyCard.visibility = View.GONE
            binding.progressbarInSearch.visibility = View.VISIBLE
            animeSearchAdapter.setData(emptyList())
            // Удаляем предыдущую задачу, чтобы избежать лишних вызовов
            if(handler != null){
                handler.removeCallbacksAndMessages(null)}

            // Запускаем задачу через 1 секунду
            handler.postDelayed({
                val searchAnimeNameText = it.toString()
                if (searchAnimeNameText.length >= 2) {
                    if (hasInternetConnection(requireActivity())){
                        viewModel.getSearchAnimeList(searchAnimeNameText)
                    }
                }
            }, 1000)
        }
        //RcViewAdapter
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.recyclerView.layoutManager = GridLayoutManager(activity as Context, 4)
        } else {
            binding.recyclerView.layoutManager = GridLayoutManager(activity as Context, 2)
        }
        val navController = findNavController()
        animeSearchAdapter = AnimeItemAdapter(requireActivity(),navController)
        binding.recyclerView.adapter = animeSearchAdapter

        viewModel.resultSearchAnimeItemLive.observe(requireActivity(),{
            binding.progressbarInSearch.visibility = View.GONE
            if (it.isNullOrEmpty()){
                binding.emptyCard.visibility = View.VISIBLE
            }else{
                binding.emptyCard.visibility = View.GONE
                animeSearchAdapter.setData(it)
            }
                })

        return binding.root
    }

}