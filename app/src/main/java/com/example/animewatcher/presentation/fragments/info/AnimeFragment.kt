package com.example.animewatcher.presentation.fragments.info

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.example.animewatcher.R
import com.example.animewatcher.databinding.FragmentAnimeBinding
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AnimeFragment : Fragment() {
    private val binding :FragmentAnimeBinding by lazy {
        FragmentAnimeBinding.inflate(layoutInflater)
    }
    //Проверка на подключение к интернету
    fun hasInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return  capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if(!hasInternetConnection(requireActivity())){
            binding.errorCard.visibility = View.VISIBLE
            binding.playCard.visibility = View.GONE
            binding.favoriteCard.visibility = View.GONE
            binding.episodeCard.visibility = View.GONE
        }else{
            arguments.let {
                val animeItem :AnimeApiItemModel? = arguments?.getParcelable(animeKey)
                with(binding){
                    animeNameText.text = animeItem!!.materialData!!.title
                    Glide.with(requireActivity()).load(animeItem.materialData!!.posterUrl).into(backgroundImage)
                    Glide.with(requireActivity()).load(animeItem.materialData.posterUrl).into(posterAnime)
                    statusText.text = animeItem.materialData.animeStatus
                    if(animeItem.materialData.description != null){
                        animeDetailsText.text = animeItem.materialData.description
                    } else {  animeDetailsText.text = getString(R.string.description_error) }
                    binding.progressbarInPage.visibility = View.GONE
                }
            }
        }




        return binding.root
    }

    companion object{
        const val animeKey ="ANIME_KEY"
    }

}