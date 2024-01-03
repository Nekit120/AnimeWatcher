package com.example.animewatcher.presentation.fragments.favorite

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animewatcher.databinding.FragmentFavoriteBinding
import com.example.animewatcher.presentation.adapters.AnimeItemAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    lateinit var  animeFavoriteAdapter : AnimeItemAdapter
    private val binding: FragmentFavoriteBinding by lazy {
        FragmentFavoriteBinding.inflate(layoutInflater)
    }
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //RcViewAdapter
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.recyclerViewFavorite.layoutManager = GridLayoutManager(activity as Context, 4)
        } else {
            binding.recyclerViewFavorite.layoutManager = GridLayoutManager(activity as Context, 2)
        }

        val navController = findNavController()
        animeFavoriteAdapter = AnimeItemAdapter(requireActivity(),navController)
        binding.recyclerViewFavorite.adapter = animeFavoriteAdapter

        viewModel.getAllListAnimeFromDB()
        viewModel.resultListAnimeLive.observe(requireActivity(),{
            if(it.isNullOrEmpty()){
                binding.emptyCard.visibility = View.VISIBLE
            }else{
                animeFavoriteAdapter.setData(it)
                binding.emptyCard.visibility = View.GONE
            }
        })
        return binding.root
    }
}